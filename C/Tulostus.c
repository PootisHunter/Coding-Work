#include <stdio.h>

int main() {

char a=97;
double f = 1.23456789;
char yksi[] = "Yksi";
char kaksi[] = "Kaksi";

printf("Muuttuja a on samaan aikaan %04d ja '%c', molemmat ovat %d%% oikein\n",a,a,100);
printf("Muuttuja f on %.4f kun tulostetaan vain osa desimaaleja\n",f);
printf("%s %s Kolme\n", yksi, kaksi);

return 0;
}