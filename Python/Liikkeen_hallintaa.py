import math

def muunna_xy_koordinaateiksi(kulma, vektorin_pituus):
    kulma = float(kulma)
    vektorin_pituus = float(vektorin_pituus)
    x = math.cos(kulma) * vektorin_pituus
    y = math.sin(kulma) * vektorin_pituus
    return round(x), round(y)
    
def kysy_liike(hahmo)
    sijainti = "Hahmo on sijainnissa ({}, {})"
    print(sijainti.format(hahmo.get("x"), hahmo.get("y")))
    input("Anna liikkumissuunta asteina:")
    input("Anna liikenopeus:")
    
    

hahmo_1 = {
    "x": 0,
    "y": 0,
    "suunta": 0,
    "nopeus": 0
}

hahmo_2 = {
    "x": 50,
    "y": 50,
    "suunta": 0,
    "nopeus": 0
}
