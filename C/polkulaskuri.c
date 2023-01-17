#include <inttypes.h>
#include <stdio.h>
#include <math.h>

struct piste {
  int koordinaatit[3];
  struct piste *seuraava;
};

struct polku {
  double matka;
  struct piste *pisteet;
};

void laske_kuljettu_matka(struct polku *polku);

void laske_kuljettu_matka(struct polku *polku){
    double mpituus = 0;
    struct piste* n = polku->pisteet;
    struct piste* n1 = n->seuraava;
    while(n1 != NULL){
        double x = (n->koordinaatit[0] - n1->koordinaatit[0]);
        double y = (n->koordinaatit[1] - n1->koordinaatit[1]);
        double z = (n->koordinaatit[2] - n1->koordinaatit[2]);
        double etaisyys = (sqrt(pow(x,2)+pow(y,2)+pow(z,2)));
        mpituus = mpituus + etaisyys;
        n = n1;
        n1 = n1->seuraava;
    }
    polku->matka = mpituus;
}

