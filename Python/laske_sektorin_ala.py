import math

def laske_sektorin_ala(ympyran_sade, sisakulma):
    ympyran_sade = float(ympyran_sade)
    sisakulma = int(sisakulma)
    sektorin_kulma = sisakulma / 360
    return sektorin_kulma * math.pi * ympyran_sade ** 2
    
x = input("Anna ympyran sade: ")
y = input("Anna sektorin sisakulma asteina: ")
print(round(laske_sektorin_ala(x, y), 4))