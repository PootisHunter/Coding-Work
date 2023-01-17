import haravasto as har

def tulvataytto(planet, x, y):
    lista = [[x, y]]
    korkeus = len(planet)
    leveys = max(len(l) for l in planet)
    if planet[y][x] == "x":
        pass
    else:
        while len(lista) > 0:
            pari = lista.pop()
            x_pari = [pari[0]-1, pari[0], pari[0]+1]
            y_pari = [pari[1]-1, pari[1], pari[1]+1]
            planet[pari[1]][pari[0]] = "0"
            for rivi in y_pari:
                for sarake in x_pari:
                    if 0 <= rivi < korkeus and 0 <= sarake < leveys:
                        if planet[rivi][sarake] == ' ':
                            lista.append([sarake, rivi])
                        else:
                            pass

def piirra_kentta(planet):
    har.tyhjaa_ikkuna()
    har.piirra_tausta()
    har.aloita_ruutujen_piirto()
    for rivi, i in enumerate(planet):
        for sarake in range(len(i)):
            har.lisaa_piirrettava_ruutu(planet[int(rivi)][sarake], sarake*40, rivi*40)
    har.piirra_ruudut()

def main(planet):

    har.lataa_kuvat("D:\\Ohjelmointi\\spritet\\spritet")
    korkeus = len(planet)
    leveys = max(len(l) for l in planet)
    har.luo_ikkuna(40*leveys, 40*korkeus)
    har.aseta_piirto_kasittelija(piirra_kentta(planet))
    har.aloita()

if __name__ == "__main__":
    planeetta = [
    [" ", " ", " ", "x", " ", " ", " ", " ", " ", " ", " ", "x", " "], 
    [" ", " ", "x", "x", " ", " ", " ", "x", " ", " ", " ", "x", " "], 
    [" ", "x", "x", " ", " ", " ", " ", "x", " ", " ", "x", "x", " "], 
    ["x", "x", "x", "x", "x", " ", " ", "x", " ", "x", " ", " ", " "], 
    ["x", "x", "x", "x", " ", " ", " ", " ", "x", " ", "x", " ", " "], 
    [" ", " ", "x", " ", " ", " ", " ", " ", " ", "x", " ", " ", " "]
    ]
    main(planeetta)