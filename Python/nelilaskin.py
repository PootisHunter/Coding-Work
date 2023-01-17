
def yhteenlasku(luku_1, luku_2):
    return luku_1 + luku_2
def vahennyslasku(luku_1, luku_2):
    return luku_1 - luku_2
def kertolasku(luku_1, luku_2):
    return luku_1 * luku_2
def jakolasku(luku_1, luku_2):
    return luku_1 / luku_2

tulos = "Tulos: {}"
valinta = input("Valitse operaatio (+, -, *, /):")
if valinta in ("+", "-", "*", "/"):
    try:
        luku1 = float(input("Anna luku 1:"))
        luku2 = float(input("Anna luku 2:"))
    except ValueError:
        print("Ei tämä ole mikään luku")
    else:
        if valinta == "+":
            print(tulos.format(yhteenlasku(luku1, luku2)))
        elif valinta == "-":
            print(tulos.format(vahennyslasku(luku1, luku2)))
        elif valinta == "*":
            print(tulos.format(kertolasku(luku1, luku2)))
        elif valinta == "/":
            if luku2 == 0:
                print("Tällä ohjelmalla ei pääse äärettömyyteen")
            else:
                print(tulos.format(jakolasku(luku1, luku2)))
        else:
            pass
else:
    print("Operaatiota ei ole olemassa")