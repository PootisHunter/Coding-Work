#include <stdio.h>
#include <inttypes.h>
#include <math.h>

float valoisuus(uint16_t rekisteri);

/*
int main(){
    printf("%.2f",valoisuus(0b0110110000110101));
    return 0;
}
*/

float valoisuus(uint16_t rekisteri){
    int16_t mask = 0b1111000000000000;
    int16_t r = rekisteri & (~mask);
    double e = (rekisteri & mask) >> 12;
    float lux = 0.01  * pow(2,e) * r;
    return lux;
}