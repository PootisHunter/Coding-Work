import haravasto as har
def kasittele_hiiri(x, y, painike, painetutnappaimet):
    """
    Tätä funktiota kutsutaan kun käyttäjä klikkaa sovellusikkunaa hiirellä.
    Tulostaa hiiren sijainnin sekä painetun napin terminaaliin.
    """
    if painike == har.HIIRI_VASEN:
        print("Hiiren nappia vasen painettiin kohdassa {x}, {y}".format(x=x, y=y))
    elif painike == har.HIIRI_OIKEA:
        print("Hiiren nappia oikea painettiin kohdassa {x}, {y}".format(x=x, y=y))
    elif painike == har.HIIRI_KESKI:
        print("Hiiren nappia keski painettiin kohdassa {x}, {y}".format(x=x, y=y))

def main():
    har.luo_ikkuna()
    har.aseta_hiiri_kasittelija(kasittele_hiiri)
    har.aloita()