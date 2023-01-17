#include <stdio.h>
#include <inttypes.h>
#include <math.h>

uint32_t ilmanpaine(uint8_t xlsb, uint8_t lsb, uint8_t msb);

/*
int main(){
    printf("%.2d",ilmanpaine(0b11011110,0b10111100,0b00011000));
    return 0;
}
*/

uint32_t ilmanpaine(uint8_t xlsb, uint8_t lsb, uint8_t msb){
    // laitetaan kaikki bitit peräkkäin tyhjään 32 bitin jonoon 
    // ja otetaan viimeisestä 4 ensimmäistä bittiä pois
    int32_t paine = (((0x0 | msb ) << 8 | lsb) << 8 | xlsb) >> 4;
    return paine;
}