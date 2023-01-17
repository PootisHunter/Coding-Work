

def sijainti_kentalla(x, y, leveys, korkeus):
    x_laidassa = False
    y_laidassa = False
    if x in (0, 1, leveys-1):
        x_laidassa = True
    if y in (0, 1, korkeus-1):
        y_laidassa = True
    if y_laidassa and x_laidassa:
        v = "nurkassa"
    elif y_laidassa or x_laidassa:
        v = "laidalla"
    elif 0 <= x <= leveys-1 and 0 <= y <= korkeus-1:
        v = "keskellä"
    else:
        v = "ulkona"
    return v

def tulosta_sijainti(avainsana):
    print(TULOSTUKSET.get(avainsana))



TULOSTUKSET = {
    "ulkona": "Antamasi ruutu on kentän ulkopuolella.",
    "nurkassa": "Antamasi ruutu on kentän nurkassa.",
    "laidalla": "Antamasi ruutu on kentän laidalla.",
    "keskellä": "Antamasi ruutu on keskikentällä."
}

kentanleveys = int(input("Anna kentän leveys: "))
kentankorkeus = int(input("Anna kentän korkeus: "))
if kentanleveys <= 0 or kentankorkeus <= 0:
    print("\nNoin pienelle kentälle ei mahdu ainuttakaan ruutua!")
else:
    x_koordinaatti = int(input("Anna x-koordinaatti: "))
    y_koordinaatti = int(input("Anna y-koordinaatti: "))
    tulosta_sijainti(sijainti_kentalla(x_koordinaatti, y_koordinaatti, kentanleveys, kentankorkeus))