#include <stdio.h>
#include <math.h>
#include <ctype.h>
#include <string.h>
#define p 2
#define size 10
#define sz2 5
#define strsz 100

int howmanyupper(char[]);
int calc(int[], int);

int calc(int arr[], int n)
{
    int sum = 0;
    int i;

    for (i = 0; i < n; i++)
        sum += pow(arr[i], p);

    return sum;
}

int main()
{
    int a[size];
    char str[strsz];
    int i;

    printf("\nInsert string : ");
    gets(str);
    puts("your string is : \n");
    printf("%s\n", str);
    printf("\n in your string there are %d uppercase letters\n", howmanyupper(str));
    printf("\n insert %d numbers\n", sz2);
    for (i = 0; i < sz2; i++)
        scanf("%d", &a[i]);

    printf("\n the result is : %d \n", calc(a, sz2));
    return 0;
}

int howmanyupper(char s1[])
{
    int cnt = 0;
    int i;

    for (i = cnt = 0; s1[i]; i++)
        if (isupper(s1[i]))
            cnt++;

    return cnt;
}