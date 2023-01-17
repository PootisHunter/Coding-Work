#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>
#include <math.h>
#include <string.h>

float keskiarvo(char *lista);

float keskiarvo(char *lista){
    char pilk[] = ",";
    char *token;

    float summa = 0;
    int8_t i = 0;

    token = strtok(lista,pilk);
    
    while( token != NULL){
        float numero = strtof(token, NULL);
        summa = summa + numero;
        i++;
        token = strtok(NULL, pilk);
    }

    float keskiarv = summa / i;
    return keskiarv;
}