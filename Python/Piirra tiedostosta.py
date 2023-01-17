def piirra_tiedostosta(tiedosto):
    with open(tiedosto) as luku:
        for line in luku.readlines():
            ar = line.strip().split(",")
            piirra_spiraali(ar[0], int(ar[1]), int(ar[2]), float(ar[3]), int(ar[4]))

def piirra_spiraali(vari, kaaret, A_sade, K_sade, paksuus=1):
    turtle.color(vari)
    turtle.pensize(paksuus)
    turtle.begin_fill()
    for i in range(kaaret):
        turtle.circle(A_sade + K_sade * i, 90)
        turtle.end_fill()