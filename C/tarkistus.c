#include <inttypes.h>
#include <stdio.h>

struct mpudata_t {
    float data[6];
} mpu;

void tarkistus(struct mpudata_t mpu, uint8_t index, float threshold);

void tarkistus(struct mpudata_t mpu, uint8_t index, float threshold){
    if(mpu.data[index] > threshold){
        int8_t i;
        int8_t n = sizeof(mpu.data)/sizeof(mpu.data[0]);
        for(i=0; i < n; i++){
            printf("%.2f", mpu.data[i]);
            if(i != n-1){
                printf(",");
            }
        }
        
    }
}