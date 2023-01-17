import aasimaaritelmat
import aasilogiikka
import aasikaytto

def main():
    aasidata = aasilogiikka.alusta()
    
    while True:
        aasikaytto.nayta_tila(aasidata)
        syote = aasikaytto.pyyda_syote(aasidata)
        
        if syote == aasimaaritelmat.RUOKI:
            aasilogiikka.ruoki(aasidata)
        elif syote == aasimaaritelmat.KUTITA:
            aasilogiikka.kutita(aasidata)
        elif syote == aasimaaritelmat.TYOSKENTELE:
            aasilogiikka.tyoskentele(aasidata)
        elif syote == aasimaaritelmat.ALUSTA:
            aasidata = aasilogiikka.alusta()
        elif syote == aasimaaritelmat.LOPETA:
            break

if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        print("Ohjelma keskeytettiin")