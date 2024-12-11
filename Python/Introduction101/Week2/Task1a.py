import random
import hashlib
import math
import string
import sys


# flag needs to be hexadecimal
def task1a_entropy(flag):
    
    hash_value = hashlib.sha256(flag.encode()).hexdigest()
     # Step 2: Convert hash to an integer
    hash_int = int(hash_value, 16)
    
    # Step 3: Map to range [8, 16]
    random_int = 8 + (hash_int % 9)  # 9 is the range size (16 - 8 + 1)
    
    print(random_int)
    return random_int

def create_password_regex(flag, min_length=8, min_requirements=False):
    character_classes = ''
    lower_count = 0
    upper_count = 0
    digit_count = 0
    available_chars = 0
    flag_bytes = flag.encode()
    flag_hash = hashlib.sha256(flag_bytes).digest()

    flag_len = len(flag_hash)
    chunk_size = flag_len // 3
    remainder = flag_len % 3
    if remainder == 1:
        chunks = [
            flag_hash[:chunk_size + 1],    # Add one extra byte to the first chunk
            flag_hash[chunk_size + 1:chunk_size * 2 + 1],
            flag_hash[chunk_size * 2 + 1:]
        ]
    elif remainder == 2:
        chunks = [
            flag_hash[:chunk_size + 1],    # Add one extra byte to the first chunk
            flag_hash[chunk_size + 1:chunk_size * 2 + 2], # Add one extra byte to the second chunk
            flag_hash[chunk_size * 2 + 2:]
        ]
    else:
        # Standard case, flag length is divisible by 3
        chunks = [
            flag_hash[:chunk_size],
            flag_hash[chunk_size:chunk_size * 2],
            flag_hash[chunk_size * 2:]
        ]

    while available_chars == 0:
        if int.from_bytes(chunks[0], "big") % 2 == 1: # Randomille flag vastike
            character_classes += f'a-z'
            lower_count = 26
        if int.from_bytes(chunks[1], "big") % 2 == 1:
            character_classes += f'A-Z'
            upper_count = 26
        if int.from_bytes(chunks[2], "big") % 2 == 1:
            character_classes += f'0-9'
            digit_count = 10
        available_chars = lower_count + upper_count + digit_count


    print(int.from_bytes)
    char_set = ''
    if lower_count > 0:
        char_set += string.ascii_lowercase
    if upper_count > 0:
        char_set += string.ascii_uppercase
    if digit_count > 0:
        char_set += string.digits
    
    parts = []
    if min_requirements:
        parts.append('(?=.*[a-z])')  # At least one lowercase letter
        parts.append('(?=.*[A-Z])')  # At least one uppercase letter
        parts.append('(?=.*[0-9])')     # At least one digit
    
    # print(char_set)
    random_string = ''.join(random.choice(char_set) for _ in range(min_length))
    pattern = '^' + ''.join(parts) + f'[{character_classes}]' + '{' + str(min_length) + '}$'
    if min_requirements:
        min_requirement_entropy = math.log2(26) + math.log2(26) + math.log2(10)
        entropy = math.log2(available_chars) * (min_length - 3) + min_requirement_entropy
    else:
        entropy = math.log2(available_chars) * min_length
    
    return pattern, entropy, random_string

def main():
    if len(sys.argv) < 2:
        print("Usage: python task1a.py <flag>")
        sys.exit(1)
    
    flag = sys.argv[1]
    random_int = task1a_entropy(flag)
    pattern, entropy, random_string = create_password_regex(flag, random_int)


if __name__ == "__main__":
    main()
