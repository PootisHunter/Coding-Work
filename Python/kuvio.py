import math

def laske_nelio_ala(sivun_pituus):
    sivun_pituus = float(sivun_pituus)
    nelion_ala = sivun_pituus * sivun_pituus
    return nelion_ala

def laske_sektorin_ala(ympyran_sade, sisakulma):
    ympyran_sade = float(ympyran_sade)
    sisakulma = int(sisakulma)
    sektorin_kulma = sisakulma / 360
    return sektorin_kulma * math.pi * ympyran_sade ** 2

def laske_sivun_pituus(hypotenuusan_pituus):
    hypotenuusan_pituus = float(hypotenuusan_pituus)
    return math.sqrt((hypotenuusan_pituus ** 2) / 2)

def laske_kuvion_ala(pituus):
    pienen_nelion_ala = laske_nelio_ala(pituus)
    kolmion_sivu = laske_sivun_pituus(pituus)
    kolmion_ala = (kolmion_sivu ** 2) / 2
    ison_nelion_ala = (kolmion_sivu * 2) ** 2
    pienen_ympyran_sektorin_ala = laske_sektorin_ala(kolmion_sivu, (180-90-45))
    ison_ympyran_sektorin_ala = laske_sektorin_ala((kolmion_sivu * 2), 360-90)
    return pienen_nelion_ala + kolmion_ala + ison_nelion_ala + pienen_ympyran_sektorin_ala + ison_ympyran_sektorin_ala

x = input("Anna x: ")
print(round(laske_kuvion_ala(x), 4))