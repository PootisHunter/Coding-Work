#include <stdio.h>
#include <inttypes.h>

void movavg(float *array, uint8_t array_size, uint8_t window_size);

int main(){
    float data[8] = { 1.0, 2.0, 4.0, 6.0, 9.0, 10.0, 12.0, 13.0 };
    movavg(data, 8, 6);
    return 0;
}

void movavg(float *array, uint8_t array_size, uint8_t window_size){
    uint8_t i;
    uint8_t k;
    float keskiarvo[array_size - window_size + 1];
    for(i = 0; i < array_size - window_size + 1; i++){
        float summa = 0;
        for (k = i; k < i + window_size; k++){
            summa = summa + array[k];
        }
        keskiarvo[i] = summa / window_size;
    }
    for(i=0; i < array_size - window_size + 1; i++){
        printf("%.2f",keskiarvo[i]);
        if(i != array_size - window_size){
            printf(",");
        }
    }
}