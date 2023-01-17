

def laske_nelion_ala(sivun_pituus):
    sivun_pituus = float(sivun_pituus)
    nelion_ala = sivun_pituus * sivun_pituus
    return nelion_ala
    

x = input("Anna nelion sivun pituus:")
print(round(laske_nelion_ala(x), 4))
