#include <stdio.h>

int main()
{

   int num, cnt = 0;

   printf("\n insert numbers \n");

   while (scanf("%d", &num) != EOF)
   {
      cnt += (num % 2) ? 0 : 1;
   }

   printf("\n you have %d even numbers\n", cnt);

   return 0;
}
