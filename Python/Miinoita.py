import random as rng
import haravasto as har
tila = {
    "kentta": []
}

def miinoita(lista, vapaa_lista, miinojen_määrä):
    for _ in range(miinojen_määrä):
        arvo = rng.choice(vapaa_lista)
        lista[arvo[1]][arvo[0]] = "x"
        vapaa_lista.remove(arvo)

def piirra_kentta():
    har.tyhjaa_ikkuna()
    har.piirra_tausta()
    har.aloita_ruutujen_piirto()
    for rivi, i in enumerate(tila["kentta"]):
        for sarake in range(len(i)):
            har.lisaa_piirrettava_ruutu(tila["kentta"][int(rivi)][sarake], sarake*40, rivi*40)
    har.piirra_ruudut()

def main():
    """
    Lataa pelin grafiikat, luo peli-ikkunan ja asettaa siihen piirtokäsittelijän.
    """
    har.lataa_kuvat("D:\\Ohjelmointi\\spritet\\spritet")
    har.luo_ikkuna(600, 400)
    har.aseta_piirto_kasittelija(piirra_kentta)
    har.aloita()