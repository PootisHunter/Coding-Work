#include <stdio.h>
#include <inttypes.h>
#include <math.h>


float kosteus(uint16_t rekisteri);
/*
int main(){
    printf("%.2f", kosteus(0b1000000000000000));
    return 0;
}
*/
float kosteus(uint16_t rekisteri){
    float kostea = rekisteri / pow(2,16) * 100;
    return kostea;
}