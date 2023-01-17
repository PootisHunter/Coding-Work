
def pyyda_syote(pyynto, virheviesti):
    while True:
        try:
            x = float(input(pyynto))
        except ValueError:
            print(virheviesti)
        else:
            if not x.is_integer():
                print(virheviesti)
            else:
                break
    return x