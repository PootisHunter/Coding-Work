#define _USE_MATH_DEFINES
#include <stdio.h>
#include <math.h>

double kartion_tilavuus(double pohjansade, double korkeus);

double kartion_tilavuus(double pohjansade, double korkeus) {
    double tilavuus = (1.0 / 3.0) * M_PI * pohjansade * pohjansade * korkeus;
    return tilavuus;
}

int main(){
    printf("%.2f \n", kartion_tilavuus(3,2));
    return 0;
}