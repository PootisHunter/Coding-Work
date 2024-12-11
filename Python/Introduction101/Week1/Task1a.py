import base64
import sys

# The task that changes based on given flag input
def task(flag):
    hex_value = flag.hex()
    hex_bytes = bytes.fromhex(hex_value)
    base64_encoded = base64.b64encode(hex_bytes).decode('utf-8')
    return base64_encoded


def generate_readme(base64_encoded):
    """
    Generates a README.txt file with a message containing the Base64-encoded text.
    
    :param base64_encoded: The Base64-encoded value to include in the README
    """
    # Define the message template
    message = (
        "You are given the base64 encoded value:\n"
        f"{base64_encoded}\n\n"
        "Can you find the flag based on it?"
    )
    
    # Write the message to a README.txt file
    with open("README.txt", "w") as file:
        file.write(message)

def main():

    if len(sys.argv) != 2:
        print("Usage: python script.py <flag>")
        sys.exit(1)

    # Get the flag from command line arguments
    flag = sys.argv[1].encode()  # Convert to bytes
    
    # Check if the flag is exactly 32 bytes
    base64_encoded = task(flag)
    generate_readme(base64_encoded)

if __name__ == "__main__":
    main()