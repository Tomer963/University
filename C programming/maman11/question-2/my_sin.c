/*
Author:Tomer Dore
Date:20/03/21
This program takes the input(number) and use tylor series to calculate
the sin of x in accuracy of 0.000001.
*/

#include <stdio.h>
#include <math.h>

double my_sin(double angle, double accuracy)
{
    int denominator;
    int i = 1;
    double x = angle;
    double sinx = angle;

    while (1) /*true*/
    {
        denominator = 2 * i * (2 * i + 1);
        x = -x * angle * angle / denominator; /*this is efficient calculate (was recommended in introduction)*/
        i++;
        if (accuracy >= fabs(sinx - (sinx + x)))
            break;
        sinx += x;
    }
    return sinx;
}

int main()
{
    double angle = 0;
    double accuracy = 0.000001;
    double sinx;
    double realSin;
    printf("please a enter a number between [-25.0,25.0]:");
    scanf("%lf", &angle);
    /* the allowed range of the angle */
    if (angle < -25.0)
        angle = -25.0;
    else if (angle > 25.0)
        angle = 25.0;
    sinx = my_sin(angle, accuracy);
    printf("my_sin(x) is: %f\n", sinx);
    /* the library func value calculate */
    realSin = sin(angle);
    printf("the math.h sin(x) is: %f\n", realSin);

    return 0;
}
