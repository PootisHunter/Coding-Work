#include <stdio.h>
#include <inttypes.h>
#include <string.h>
#include <stdlib.h>

void merkkilaskuri(char *str, uint8_t *tulos);
/*
int main(){
    uint8_t * tulo[] = {0, 0};
    char * str[] ={'Guinevere Carcinogen Narrow'};
    merkkilaskuri(*str, *tulo);
    return 0;
}
*/
// käy läpi listan arvot ja vertaa niitä vokaali ja konsonantti listojen arvoihin jos löytää
// saman kasvattaa määrää yhdellä ja sijoittaa määrän tulos muuttujaan
void merkkilaskuri(char *str, uint8_t *tulos){
    char vokaalit[] = {"aeiouAEIOU"};
    char konsonantit[] = {"bcdfghjklmnpqrstvwxyz"};
    char isokonsonantit[] = {"BCDFGHJKLMNPQRSTVWXYZ"};
    uint8_t vokal = 0;
    uint8_t kons = 0;
    int16_t i;
    int16_t j;
    for(i = 0; i < strlen(str);i++){
        for(j=0; j < strlen(vokaalit); j++){
            if(str[i] == vokaalit[j]){
                vokal++;
            }
        }
        for(j=0; j < strlen(konsonantit); j++){
            if(str[i] == konsonantit[j]){
                kons++;
            }
            if(str[i] == isokonsonantit[j]){
                kons++;
            }
        }
    }
    tulos[0] = vokal;
    tulos[1] = kons;
}


