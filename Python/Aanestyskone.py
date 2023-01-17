import random

def aanesta(sanakirja):
    print("Anna aanesi, vaihtoehdot ovat:")
    valikoima = str(sanakirja.keys())
    print(valikoima.lstrip("dict_keys").replace("()[]", ""))
    aani = str(input(":").lower())
    if aani in sanakirja:
        sanakirja[aani] += 1
    else:
        sanakirja["virhe"] += 1

def nayta_tulokset(sanakirja):
    for key, value in sanakirja.items():
        print(key," : ", value * "#")


verouudistus = {
    "jaa": 0,
    "ei": 0,
    "eos": 0,
    "virhe": 0
}
nalle_puh_presidentiksi = {
    "jaa": 12,
    "ei": 0,
    "eos": 5,
    "virhe": 4
}

print("Suoritetaanko verouudistus?")
kerrat = random.randint(1,5)
for _ in range(kerrat):
    aanesta(verouudistus)
nayta_tulokset(verouudistus)
print("Nalle Puh presidentiksi?")
kerrat2 = random.randint(1,5)
for _ in range(kerrat2):
    aanesta(nalle_puh_presidentiksi)
nayta_tulokset(nalle_puh_presidentiksi)
