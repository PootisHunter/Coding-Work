#include <stdio.h>
#include <math.h>
#include <inttypes.h>
#define str_width 21

int main(){
    char str[str_width];
    float x;
    float y;
    float z;
    printf("%6hi,%lu,%li", x, y, z);
    sprintf(str,"%07.2f,%07.2f,%07.2f", x, y, z);
    printf("%5d,%+d,%-6u", x, y, z);
    sprintf(str,"press:%-6hu,light:%d,humid:%hi", x, y, z);
    sprintf(str,"%06.3f,%06.3f,%06.3f", x, y, z);
    return 0;
}

