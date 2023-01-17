#include <stdio.h>
#include <inttypes.h>

int64_t laske_kertoma(int8_t n);

/*
int main(){
    printf("%lld", laske_kertoma(20));
    return 0;
}
*/

int64_t laske_kertoma(int8_t n){
    int8_t i;
    int64_t kertoma = 1;
    if (n > 20){
        return -1;
    } else{
        for(i=1; i <= n; i++) {
        kertoma = kertoma * i;
        }
        return kertoma;
    }
}

