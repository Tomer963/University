#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
  char str1[] = "abcxyzwwywcxzzzz";
  char str2[] = "1yzw23456uyTRgdh";
  char str3[100];

  int i;
  int cntdigits = 0, cntletters = 0, cntlower = 0, cntupper = 0;

  printf("\n str1= %s\n", str1);
  puts(str1);
  printf("\n str2= %s\n", str2);
  printf("\n strlen(str1)= %d\n", strlen(str1));
  printf("\n strlen(str2)= %d\n", strlen(str2));
  printf("\n strcmp(str1,str2) =  %d\n", strcmp(str1, str2));
  printf("\n strncmp(str1+4,str2+1,3) = %d\n",
         strncmp(str1 + 4, str2 + 1, 3));
  printf("\n strcpy(str3,str1+4) = %s\n", strcpy(str3, str1 + 4));
  printf("\n strncpy(str3+1,str2+3,2) = %s \n",
         strncpy(str3 + 1, str2 + 3, 2));
  printf("\n is strchr(str1,'8')==NULL? %s \n",
         strchr(str1, '8') ? "True" : "False");
  printf("\n is strchr(str1,'y')!=NULL? %s \n",
         strchr(str1, 'y') ? "True" : "False");
  printf("\n what is the index of the first 'y' at str1 %d \n",
         strchr(str1, 'y') - str1);
  printf("\n what is the index of the last 'y' at str1 %d \n",
         strrchr(str1, 'y') - str1);
  printf("\n what is the index of the first \"cx\" at str1 %d \n",
         strstr(str1, "cx") - str1);
  printf("\n strcpy(str3,str1) =  %s\n", strcpy(str3, str1));
  printf("\n strcat(str3,str2) =  %s\n", strcat(str3, str2));

  printf("\n str2 before  = %s\n", str2);

  for (i = 0; str2[i]; i++)
  {
    cntdigits += (isdigit(str2[i])) ? 1 : 0;
    cntletters += (isalpha(str2[i])) ? 1 : 0;
    cntlower += (islower(str2[i])) ? 1 : 0;
    cntupper += (isupper(str2[i])) ? 1 : 0;
    str2[i] = (islower(str2[i])) ? toupper(str2[i]) : tolower(str2[i]);
  }

  printf("\n str2 has %d digits characters\n", cntdigits);
  printf("\n str2 has %d letters characters\n", cntletters);
  printf("\n str2 has %d uppercase characters\n", cntupper);
  printf("\n str2 has %d lowercase characters\n", cntlower);
  printf("\n str2 after replacing between lower and upper = %s \n", str2);

  return 0;
}
