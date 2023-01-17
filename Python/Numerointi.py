def laske_miinat(x, y, kentta):
    '''
    Laskee kentän annetusta koordinaatti pisteestä ympäröivät miinat \n
    palauttaa miinojen lukumäärän (int)
    '''
    try:
        m = int(0)
        korkeus = len(kentta)
        leveys = max(len(l) for l in kentta)
        x_pari = [x-1, x, x+1]
        y_pari = [y-1, y, x+1]
        for sarake in y_pari:
                for rivi in x_pari:
                    if 0 <= sarake < korkeus and 0 <= rivi < leveys:
                        if kentta[sarake][rivi] == "x":
                            m += 1
    except Exception:
        print("Virhe laske_miinat funktiossa")
    return m

def numerointi(kentta, miinalista):
    '''
    Laittaa miinoitetulle kentälle numerot miinoja ympäröiviin tyhjiin ruutuihin käyttäen laske_miinat funktiota \n
    Parametrit: \n
    kenttä, joka halutaan numeroida \n
    miinalista, lista miinojen [x, y] koordinaateista
    '''
    leveys = max(len(l) for l in kentta)
    korkeus = len(kentta)
    miinat = list(miinalista)
    while miinat > 0:
        pari = miinat.pop()
        x_pari = [pari[0]-1, pari[0], pari[0]+1]
        y_pari = [pari[1]-1, pari[1], pari[1]+1]
        for sarake in y_pari:
                for rivi in x_pari:
                    if 0 <= sarake < korkeus and 0 <= rivi < leveys:
                        if kentta[sarake][rivi] == 'x':
                            pass
                        else:
                            kentta[sarake][rivi] = "{}".format(laske_miinat(rivi, sarake, kentta))
