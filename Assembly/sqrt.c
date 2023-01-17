#include <stdio.h>
#include <inttypes.h>

int16_t num = 2345;
int32_t res = 0;
int32_t bit = 1 << 16; 

void main(){
    while (bit > num) {
        bit >>= 2;
    }
   
    while (bit != 0) {
        if (num >= res + bit) {
            num -= res + bit;
            res = (res >> 1) + bit;
    } else {
        res >>= 1;
    }
    bit >>= 2;
    }
}
