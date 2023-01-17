


def laske_ninjat(x, y, rakenne):
    n = 0
    leveys = max(len(l) for l in rakenne)
    for b, _ in enumerate(reversed(rakenne)):
        for a in (k for k in range(leveys) if 0 <= x < leveys):
            if a in (x-1, x, x+1):
                if b in (y-1, y, y+1):
                    if rakenne[b][a] == "N":
                        n += 1
    return n


huone = [['N', ' ', ' ', ' ', ' '],
         ['N', 'N', 'N', 'N', ' '],
         ['N', ' ', 'N', ' ', ' '],
         ['N', 'N', 'N', ' ', ' '],
         [' ', ' ', ' ', ' ', ' '],
         [' ', ' ', ' ', ' ', ' ']]
            
print(laske_ninjat(0, 0, huone))