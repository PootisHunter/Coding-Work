def kysy_salasana():
    while True:
        salasana = str(input("Kirjoita salasana: "))
        if len(salasana) < 8:
            print("Salasanan tulee olla vähintään 8 merkkiä pitkä")
        else:
            return salasana