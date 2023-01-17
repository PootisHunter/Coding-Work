#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <inttypes.h>

void shuffle(uint8_t *list, uint16_t list_size);

int main(){

    srand(time(NULL));
    uint8_t list[8] = {1,2,3,4,5,6,7,8};
    shuffle(list,8);
    uint8_t i;
    for(i = 0; i < 8; i++){
        printf("%d",list[i]);
    }
    return 0;
}

void shuffle(uint8_t *list, uint16_t list_size){
    uint8_t i;
    uint8_t k;
    for (i= list_size; i > 0; i--){
        uint8_t valinta = rand() % (i);
        uint8_t siirto = list[valinta];
        for(k = valinta; k < list_size; k++){
            list[k] = list[k+1];
        }
        list[list_size-1] = siirto;
    }
}