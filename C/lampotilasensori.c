#include <stdio.h>
#include <inttypes.h>


float lampotila(uint16_t rekisteri, float kerroin);
/*
int main(){
    printf("%.2f", lampotila(0b0011001000000000,0.03125));
    return 0;
}
*/
float lampotila(uint16_t rekisteri, float kerroin){
    uint16_t m_rekisteri = rekisteri >> 2;
    return m_rekisteri * kerroin;
}
