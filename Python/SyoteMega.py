
def pyyda_syote(pyynto, virheviesti):
    while True:
        try:
            x = float(input(pyynto))
        except ValueError:
            print(virheviesti)
        else:
            if not x.is_integer() or x <= 1:
                print(virheviesti)
            else:
                break
    return int(x)

def tarkista_alkuluku(luku):
    totuus = True
    for i in range(2, luku//2):
        if (luku % i) == 0:
            totuus = False
            break
    
    return totuus


if tarkista_alkuluku(pyyda_syote("Anna kokonaisluku joka on suurempi kuin 1:", "Pieleen meni :'(")):
    print("Kyseessä on alkuluku.")
else:
    print("Kyseessä ei ole alkuluku.")