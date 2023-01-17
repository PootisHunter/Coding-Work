#include <inttypes.h>
#include <stdio.h>


struct sensor_data
{
    float accelerometer[3];
    float gyro[3];
    float temperature;
    float humidity;
    uint16_t light;
    float pressure;
};
