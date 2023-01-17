import haravasto as har
import ikkunasto as ik
import time as tm
from random import choice
from os import _exit
import datetime

helppo = {
    "korkeus" : 9,
    "leveys" : 9,
    "miinat" : 10
}
keskivaikea = {
    "korkeus" : 16,
    "leveys" : 16,
    "miinat" : 40
}
vaikea = {
    "korkeus" : 16,
    "leveys" : 30,
    "miinat" : 99
}
mukautettu = {
    "korkeus" : 16,
    "leveys" : 30,
    "miinat" : 99
}

Kenttatiedot = {
    "miinojen_maara" : 0,
    "kentan_leveys" : 0,
    "kentan_korkeus" : 0,
    "Vuorot" : 0,
    "kello" : 0,
    "Tila" : 0,
    "miina_kentta" : [],
    "painike_kentta" : []
}




startti = (r'''                                              
 __  __ _                                                   
|  \/  (_)                                                  
| \  / |_ _ __   ___  _____      _____  ___ _ __   ___ _ __ 
| |\/| | | '_ \ / _ \/ __\ \ /\ / / _ \/ _ \ '_ \ / _ \ '__|
| |  | | | | | |  __/\__ \\ V  V /  __/  __/ |_) |  __/ |   
|_|  |_|_|_| |_|\___||___/ \_/\_/ \___|\___| .__/ \___|_|   
                                            | |             
                                            |_|             
                                                            
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣧⠀⠀⠀⢰⡿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡟⡆⠀⠀⣿⡇⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀              
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⣿⠀⢰⣿⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⡄⢸⠀⢸⣿⡇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⡇⢸⡄⠸⣿⡇⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⢸⡅⠀⣿⢠⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣥⣾⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⡿⡿⣿⣿⡿⡅⠀⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠉⠀⠉⡙⢔⠛⣟⢋⠦⢵⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣄⠀⠀⠁⣿⣯⡥⠃⠀⢳⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⡇⠀⠀⠀⠐⠠⠊⢀⠀⢸⠀⠀⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⡿⠀⠀⠀⠀⠀⠈⠁⠀⠀⠘⣿⣄⠀⠀⠀⠀⠀           
            ⠀⠀⠀⠀⠀⣠⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀           
            ⠀⠀⠀⠀⣾⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣧⠀⠀           
            ⠀⠀⠀⡜⣭⠤⢍⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢛⢭⣗⠀           
            ⠀⠀⠀⠁⠈⠀⠀⣀⠝⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠠⠀⠀⠰⡅            
            ⠀⠀⠀⢀⠀⠀⡀⠡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠔⠠⡕⠀            
            ⠀⠀⠀⠀⣿⣷⣶⠒⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⠀            
            ⠀⠀⠀⠀⠘⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠀⠀⠀⠀⠀            
            ⠀⠀⠀⠀⠀⠈⢿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠊⠉⢆⠀⠀⠀⠀            
            ⠀⢀⠤⠀⠀⢤⣤⣽⣿⣿⣦⣀⢀⡠⢤⡤⠄⠀⠒⠀⠁⠀⠀⠀⢘⠔⠀⠀⠀⠀          
            ⠀⠀⠀⡐⠈⠁⠈⠛⣛⠿⠟⠑⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀            
            ⠀⠀⠉⠑⠒⠀⠁⠀⠀⠀⠀⠀⠀                                 
                                                             
    Valitse vaikeusaste                                      
    (H)Helppo: 9x9 kenttä ja 10 miinaa                       
    (K)Keskivaikea: 16x16 kenttä ja 40 miinaa                
    (V)Vaikea: 16x30 kenttä ja 99 miinaa                     
    (M)Mukautettu: Valitse kentän koko ja miinojen määrä     
    ''')


def helppo_nappi():
    Kenttatiedot["miinojen_maara"] = helppo["miinat"]
    Kenttatiedot["kentan_korkeus"] = helppo["korkeus"]
    Kenttatiedot["kentan_leveys"] = helppo["leveys"]
    kayttoliittyma.destroy()

def keskivaikea_nappi():
    Kenttatiedot["miinojen_maara"] = keskivaikea["miinat"]
    Kenttatiedot["kentan_korkeus"] = keskivaikea["korkeus"]
    Kenttatiedot["kentan_leveys"] = keskivaikea["leveys"]
    kayttoliittyma.destroy()

def vaikea_nappi():
    Kenttatiedot["miinojen_maara"] = vaikea["miinat"]
    Kenttatiedot["kentan_korkeus"] = vaikea["korkeus"]
    Kenttatiedot["kentan_leveys"] = vaikea["leveys"]
    kayttoliittyma.destroy()

def mukautettu_nappi():
    global mukautettuvalikko
    mukautettuvalikko = ik.luo_ali_ikkuna("Mukautettu")
    kenttakehys = ik.luo_kehys(mukautettuvalikko, ik.YLA)
    nappikehys = ik.luo_kehys(mukautettuvalikko, ik.YLA)
    ohjekehys = ik.luo_kehys(kenttakehys, ik.VASEN)
    syotekehys = ik.luo_kehys(kenttakehys, ik.VASEN)
    ik.luo_tekstirivi(ohjekehys, "Kentän korkeus (1-26):")
    mukautettu["korkeus"] = ik.luo_tekstikentta(syotekehys)
    ik.luo_tekstirivi(ohjekehys, "Kentän leveys (1-47) :")
    mukautettu["leveys"] = ik.luo_tekstikentta(syotekehys)
    ik.luo_tekstirivi(ohjekehys, "Miinojen lukumäärä:")
    mukautettu["miinat"] = ik.luo_tekstikentta(syotekehys)
    ik.luo_nappi(nappikehys, "Tallenna", tallenna_mukautettu)
    mukautettuvalikko.mainloop()

def tilasto_nappi():
    with open("Tilastot.txt", "r") as tilasto:
        for line in tilasto.readlines(500):
            print(line)
    

def tallenna_mukautettu():
    try:
        korkeus = int(ik.lue_kentan_sisalto(mukautettu["korkeus"]))
    except ValueError:
        ik.avaa_viesti_ikkuna("Virhe", "Anna korkeus kokonaislukuna")
    try:
        leveys = int(ik.lue_kentan_sisalto(mukautettu["leveys"]))
    except ValueError:
        ik.avaa_viesti_ikkuna("Virhe", "Anna leveys kokonaislukuina")
    try:
        miinat = int(ik.lue_kentan_sisalto(mukautettu["miinat"]))
    except ValueError:
        ik.avaa_viesti_ikkuna("Virhe", "Anna miinat kokonaislukuina")
    print(korkeus,leveys, miinat)
    if 1 <= korkeus <= 26 and 1 <= leveys <= 47 and miinat <= korkeus * leveys:
        Kenttatiedot["kentan_korkeus"] = korkeus
        Kenttatiedot["kentan_leveys"] = leveys
        Kenttatiedot["miinojen_maara"] = miinat
        kayttoliittyma.destroy()
    else:
        ik.avaa_viesti_ikkuna("Virhe", "Anna pituudet mittaväleissä ja miinoja kentälle mahtuva määrä")


def luo_kentat(kentta_korkeus, kentta_leveys):
    miina_kentta = []
    painike_kentta = []
    for _ in range(kentta_korkeus):
        miina_kentta.append([])
        painike_kentta.append([])
        for _ in range(kentta_leveys):
            miina_kentta[-1].append(" ")
            painike_kentta[-1].append(" ")       
    Kenttatiedot["miina_kentta"] = miina_kentta
    Kenttatiedot["painike_kentta"] = painike_kentta

def listaa_kentta():
    lista = []
    for x in range(Kenttatiedot["kentan_leveys"]):
        for y in range(Kenttatiedot["kentan_korkeus"]):
            lista.append([x, y])
    return lista

def miinoita(kentta, vapaa_lista, miinojen_määrä):
    '''
    Laittaa kentälle satunnaisesti annetun määrän miinoja ("x") 
    vapaasta listasta koordinaatteja muotoa [x, y]  
    palauttaa listan laitettujen miinojen koordinaatteista muotoa [x, y]
    '''

    lista = list(vapaa_lista)
    while miinojen_määrä:
        x, y = choice(lista)
        if kentta[y][x] != "x":
            kentta[y][x] = "x"
            lista.remove([x, y])
            miinojen_määrä -= 1
    

def laske_miinat(x, y, kentta):
    '''
    Laskee kentän annetusta koordinaatti pisteestä ympäröivät miinat 
    palauttaa miinojen lukumäärän (int)
    parametrit:
    x, laskettavan ruudun x-koordinaatti
    y, laskettavan ruudun y-koordinaatti
    kentta, kenttä jossa laskenta suoritetaan
    '''
        
    m = int(0)
    x_pari = [x-1, x, x+1]
    y_pari = [y-1, y, y+1]
    for y_kohta in y_pari:
            for x_kohta in x_pari:
                if 0 <= y_kohta < Kenttatiedot["kentan_korkeus"] and 0 <= x_kohta < Kenttatiedot["kentan_leveys"]:
                    if kentta[y_kohta][x_kohta] == "x":
                        m += 1
    return m

def numerointi(kentta):
    '''
    Laittaa miinoitetulle kentälle numerot miinoja ympäröiviin tyhjiin ruutuihin käyttäen laske_miinat funktiota 
    Parametrit: 
    kenttä, joka halutaan numeroida
    '''
    for y, sarake in enumerate(kentta):
        for x, kohta in enumerate(sarake):
            if kohta != "x":
                kentta[y][x] = str(laske_miinat(x,y,kentta))
        
    

def tulvataytto(x, y):
    lista = []
    lista.append([x, y])
    käydyt = []
    while len(lista) > 0:
        pari = lista.pop()
        x_pari = [pari[0]-1, pari[0], pari[0]+1]
        y_pari = [pari[1]-1, pari[1], pari[1]+1]
        Kenttatiedot["painike_kentta"][y][x] = Kenttatiedot["miina_kentta"][y][x]
        for sarake in y_pari:
            for rivi in x_pari:
                if 0 <= sarake < Kenttatiedot["kentan_korkeus"] and 0 <= rivi < Kenttatiedot["kentan_leveys"]:
                    if (rivi, sarake) not in käydyt:
                        if Kenttatiedot["miina_kentta"][sarake][rivi] == '0':
                            Kenttatiedot["painike_kentta"][sarake][rivi] = Kenttatiedot["miina_kentta"][sarake][rivi]
                            lista.append([rivi, sarake])
                            käydyt.append((rivi, sarake))
                        elif Kenttatiedot["miina_kentta"][sarake][rivi] != "x" and Kenttatiedot["miina_kentta"][sarake][rivi] != "0":
                            Kenttatiedot["painike_kentta"][sarake][rivi] = Kenttatiedot["miina_kentta"][sarake][rivi]

def piirrot():
    har.tyhjaa_ikkuna()
    har.piirra_tausta()
    har.aloita_ruutujen_piirto()
    for i, rivi in enumerate(Kenttatiedot["painike_kentta"]):
        for x, key in enumerate(rivi):
            har.lisaa_piirrettava_ruutu(key, x * 40, i *40)
    har.piirra_ruudut()

def ruudun_avaus(x, y):
    if Kenttatiedot["painike_kentta"][y][x] == " ":
        if Kenttatiedot["miina_kentta"][y][x] == "x":
            Kenttatiedot["Vuorot"] += 1
            havio()
        elif int(Kenttatiedot["miina_kentta"][y][x]) > 0:
            Kenttatiedot["painike_kentta"][y][x] = Kenttatiedot["miina_kentta"][y][x]
            Kenttatiedot["Vuorot"] += 1
            voittotesti()
        elif Kenttatiedot["miina_kentta"][y][x] == "0":
            Kenttatiedot["Vuorot"] += 1
            tulvataytto(x, y)
            voittotesti()
    elif Kenttatiedot["Tila"] == 1:
        Kenttatiedot["Tila"] = 0
        Kenttatiedot["kentan_korkeus"] = 0
        Kenttatiedot["kentan_leveys"] = 0
        Kenttatiedot["miinojen_maara"] = 0
        Kenttatiedot["kello"] = 0
        Kenttatiedot["Vuorot"] = 0
        har.lopeta()
        main()
    piirrot() #väärä paikka

def kellokayntiin():
    Kenttatiedot["kello"] = tm.time()

def kello_stop():
    loppu = tm.time()
    kesto = loppu - Kenttatiedot["kello"]
    return kesto

def liputus(x, y):
    if Kenttatiedot["painike_kentta"][y][x] == " ":
        Kenttatiedot["painike_kentta"][y][x] = "f"
    elif Kenttatiedot["painike_kentta"][y][x] == "f":
        Kenttatiedot["painike_kentta"][y][x] = " "
    piirrot()

def voittotesti():
    tyhjat = 0
    for _, i in enumerate(Kenttatiedot["painike_kentta"]):
        tyhjat += i.count("0") + i.count("1") + i.count("2") + i.count("3") + i.count("4") + i.count("5") + i.count("6") + i.count("7") + i.count("8")
        if tyhjat == Kenttatiedot["kentan_korkeus"] * Kenttatiedot["kentan_leveys"] - Kenttatiedot["miinojen_maara"]:
            aika = kello_stop()
            print("Voitit pelin")
            print("Peli kesti {:.2f} sekunttia ja {} vuoroa". format(kello_stop(), Kenttatiedot["Vuorot"]))
            with open("Tilastot.txt","a") as tilasto:
                tilasto.write("{a}, {b} min, {c} vuoron voitto, {d}x{e}, {f} miinalla\n".format(
                    a=str(datetime.datetime.now()),
                    b=str(round(aika / 60, 3)),
                    c=str(Kenttatiedot["Vuorot"]),
                    d=str(Kenttatiedot["kentan_korkeus"]),
                    e=str(Kenttatiedot["kentan_leveys"]),
                    f=str(Kenttatiedot["miinojen_maara"])))
            Kenttatiedot["Tila"] = 1
            

def havio():
    aika = kello_stop()
    print("Hävisit pelin")
    print("Peli kesti {:.2f} sekunttia ja {} vuoroa".format(aika, Kenttatiedot["Vuorot"]))
    Kenttatiedot["painike_kentta"] = Kenttatiedot["miina_kentta"]
    with open("Tilastot.txt","a") as tilasto:
        tilasto.write("{a}, {b} min, {c} vuoron häviö, {d}x{e}, {f} miinalla\n".format(
            a=str(datetime.datetime.now()),
            b=str(round(aika / 60, 3)),
            c=str(Kenttatiedot["Vuorot"]),
            d=str(Kenttatiedot["kentan_korkeus"]),
            e=str(Kenttatiedot["kentan_leveys"]),
            f=str(Kenttatiedot["miinojen_maara"])))
    Kenttatiedot["Tila"] = 1
    piirrot()
    


def kasittele_hiiri(x, y, painike, painetutnappaimet):
    """
    Tätä funktiota kutsutaan kun käyttäjä klikkaa sovellusikkunaa hiirellä.
    Tulostaa hiiren sijainnin sekä painetun napin terminaaliin.
    """
    x = int(x / 40)
    y = int(y / 40)
    if painike == har.HIIRI_VASEN:
        ruudun_avaus(x, y)
    elif painike == har.HIIRI_OIKEA:
        liputus(x, y)

 
def peli():
    har.lataa_kuvat("spritet")
    har.luo_ikkuna(Kenttatiedot["kentan_leveys"] * 40, Kenttatiedot["kentan_korkeus"] * 40, taustavari=(0,0,0,255))
    luo_kentat(Kenttatiedot["kentan_korkeus"], Kenttatiedot["kentan_leveys"])
    miinoita(Kenttatiedot["miina_kentta"], listaa_kentta(), Kenttatiedot["miinojen_maara"])
    numerointi(Kenttatiedot["miina_kentta"])
    har.lataa_kuvat("spritet")

def valikko():
    global kayttoliittyma
    kayttoliittyma = ik.luo_ikkuna("Minesweeper")
    kehys = ik.luo_kehys(kayttoliittyma)
    laatikko = ik.luo_tekstilaatikko(kehys, 60, 48)
    ik.kirjoita_tekstilaatikkoon(laatikko, startti)
    ik.luo_nappi(kehys,"Helppo", helppo_nappi)
    ik.luo_nappi(kehys,"Keskivaikea", keskivaikea_nappi)
    ik.luo_nappi(kehys,"Vaikea", vaikea_nappi)
    ik.luo_nappi(kehys,"Mukautettu", mukautettu_nappi)
    ik.luo_nappi(kehys,"Tilastot", tilasto_nappi)
    kayttoliittyma.mainloop()
    if Kenttatiedot["kentan_korkeus"] == 0 and Kenttatiedot["kentan_leveys"] == 0 and Kenttatiedot["miinojen_maara"] == 0:
        _exit(1)

def main():
    valikko()
    peli()
    har.aseta_piirto_kasittelija(piirrot)
    har.aseta_hiiri_kasittelija(kasittele_hiiri)
    kellokayntiin()
    har.aloita()

if __name__ == "__main__":
    main()