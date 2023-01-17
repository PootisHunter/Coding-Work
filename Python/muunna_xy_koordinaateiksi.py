import math

def muunna_xy_koordinaateiksi(kulma, vektorin_pituus):
    kulma = float(kulma)
    vektorin_pituus = float(vektorin_pituus)
    x = math.cos(kulma) * vektorin_pituus
    y = math.sin(kulma) * vektorin_pituus
    return round(x), round(y)
