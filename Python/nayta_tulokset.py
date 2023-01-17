def nayta_tulokset(tiedosto):
    with open(tiedosto) as luku:
        for line in luku.readlines():
            kohdat = line.strip().split(",")
            print("{pl1} {ps1} - {ps2} {pl2}".format(
                pl1=kohdat[0],
                ps1=kohdat[2],
                ps2=kohdat[3],
                pl2=kohdat[1]
            ))
