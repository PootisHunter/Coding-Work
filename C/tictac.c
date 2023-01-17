#include <stdio.h>
#include <inttypes.h>

int kasittely(int8_t * gameboard, int8_t ruutu, int win_len);
int8_t tictactoe_check(int8_t * gameboard, int win_len);
/*
int main(){
    int8_t lista[100];
    tictactoe_check(lista, 3);
    return 0;
}
*/
// checks if there is line to below, right or diagonally downwards
// if there is function return 1 for win and 0 for not
// ruutu = indeksi ruudulle
// gameboard = pelilauta pötkönä
// win_len = suoran pituus voittoon
int kasittely(int8_t * gameboard, int8_t ruutu, int win_len){
    int t = 1;
    int8_t i;
    for(i=1; i < win_len + 1; i++){
        if ((ruutu + 1 * i) % 10 != 0){
            if(gameboard[ruutu + 1 * i] == gameboard[ruutu]){
                t++;
            }
        } else {
            break;
        }
    }
    if(t == win_len){
        return 1;
    }
    t = 1;
    for(i=1; i < win_len + 1; i++){
        if((ruutu + 10 * i) <= 99 ){
            if(gameboard[ruutu + 10 * i] == gameboard[ruutu]){
                t++;
            }
        } else {
            break;
        }
    }
    if(t == win_len){
        return 1;
    }
    t = 1;
    if((ruutu % 10) != 0){
        for(i=1; i < win_len + 1; i++){
            if(gameboard[ruutu + 9 * i] == gameboard[ruutu]){
                t++;
            }
        }
        if(t == win_len){
            return 1;
        }
    }
    t = 1;
    for(i=1; i < win_len + 1; i++){
        if((ruutu + 1) % 10 != 0) {
            if(gameboard[ruutu + 11 * i] == gameboard[ruutu]){
                t++;
            }
        } else {
            break;
        }
    }
    if(t == win_len){
        return 1;
    }
    return 0;
}
// checks every value on the list if its 1 or 2 runs checking
int8_t tictactoe_check(int8_t * gameboard, int win_len){
    int8_t i;
    int x = 0;
    int o = 0;
    for(i=0; i<100; i++){
        if (gameboard[i] == 1 && x == 0){
           if(kasittely(gameboard, i, win_len) == 1){
                x = 1;
                continue;
           }
        }
        if (gameboard[i] == 2 && o == 0){
            if(kasittely(gameboard, i, win_len) == 1){
                o = 1;
                continue;
            }

        }
    }
    if((x == 1 && o == 1) || (x == 0 && o == 0)){
        return 0;
    }
    if(x == 1){
        return 1;
    }
    return 2;
}