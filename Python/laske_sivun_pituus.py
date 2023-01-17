from math import sqrt

def laske_sivun_pituus(hypotenuusan_pituus):
    hypotenuusan_pituus = float(hypotenuusan_pituus)
    return sqrt((hypotenuusan_pituus ** 2) / 2)
    
x = input("Anna tasakylkisen kolmion pituus: ")
print(round(laske_sivun_pituus(x), 4))
