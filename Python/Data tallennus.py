def tallenna_summat(data, tiedosto):
    with open(tiedosto, "w") as kohde:
        for vuosi in data:
            kohde.write("{kvar1}:{kvar2}:{kvar3}:{kvar4}\n".format(
                kvar1=vuosi[0],
                kvar2=vuosi[1],
                kvar3=vuosi[2],
                kvar4=vuosi[3]
            ))
kvartaalitulokset = [
    ["$123,123,123", "$56,548", "$666,666,666,666", "$945,246,000"], 
    ["$45", "$645,231", "$765,312,765", "$12,000,000,001"],
    ["$18,618,639", "$911", "$312", "$517,629,086"],
    ["$633,811", "$243,632,851,833,606", "$328,421,688,104", "$803"],
    ["$626", "$235,493,388", "$469,980", "$985,435,012,285,386"],
    ["$34,934", "$829,830,625,455", "$757,180,630,342,645", "$615,239"],
    ["$214,081", "$350,257", "$669", "$98,002,803,712,471"],
    ["$807,266,013,233", "$43,931,320,272,886", "$106,873,623,674", "$409,966"],
    ["$901", "$23,797,858,928,694", "$916", "$648,091,994,611"]
]
tallenna_summat(kvartaalitulokset, "kvartaalit_2001-2009.txt")