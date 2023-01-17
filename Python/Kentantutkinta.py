
ELAIMET = {
    "a": "aasi",
    "k": "koira",
    "@": "kissa",
    "h": "hemuli",
    "l": "lammas"
}

def tutki_ruutu(merkki, rivi, sarake):
    if merkki in ELAIMET:
        print(f' Ruudusta ({sarake}, {rivi}) löytyy {ELAIMET.get(merkki)}')
    else:
        pass

def tutki_kentta(kentta):
    for y, _ in enumerate(reversed(kentta)):
        for x in range(max(len(l) for l in kentta)):
            tutki_ruutu(kentta[y][x], y, x)

pelto = [
    [" ", "a", " ", " ", "l"],
    [" ", "k", "@", "k", " "],
    ["h", " ", "a", "k", " "]
]
tutki_kentta(pelto)
