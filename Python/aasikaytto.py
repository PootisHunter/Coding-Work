import aasimaaritelmat as am

def nayta_tila(sanakirja):
    print('''
    Aasi on {ika} vuotta vanha ja rahaa on {raha} mk.
    Kylläisyys: {kyllais}
    Onnellisuus: {onnellis}
    Jaksaminen: {jaksami}
    '''.format(ika=sanakirja["IKÄ"], raha=sanakirja["RAHA"], kyllais=sanakirja["KYLLÄISYYS"],
    onnellis=sanakirja["ONNELLISUUS"], jaksami=sanakirja["JAKSAMINEN"]))

def pyyda_syote(kirja):
    if kirja["ELÄKE"] == True:
        print("Valinnat: {x}, {y}".format(x=am.ELAKEVALINNAT[0], y=am.ELAKEVALINNAT[1]))
    else:
        print("Valinnat: {x}, {y}, {z}, {w}".format(x=am.VALINNAT[0], y=am.VALINNAT[1], \
            z=am.VALINNAT[2], w=am.VALINNAT[3]))
    while True:
        syote = str(input("Anna seuraava valinta: "))
        if kirja["ELÄKE"] == True:
            if syote not in am.ELAKEVALINNAT:
                print("Virheellinen syöte!")
            else:
                break
        else:
            if syote not in am.VALINNAT:
                print("Virheellinen syöte!")
            else:
                break
    return syote
            