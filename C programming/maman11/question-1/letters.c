/*
Author:Tomer Dore
Date:20/03/21
This program takes the input and outputs it with 
changes according to the instructions of the question.
*/
#include <stdio.h>
#include <ctype.h>

/*The different states of the input text.*/
enum status
{
    OUT,
    NEW_SENTENCE,
    IN_STRING
};

int main()
{
    int character;
    int state = NEW_SENTENCE;

    while ((character = getchar()) != EOF)
        if (!isdigit(character))/*If there is a number in the input then the program will skip it.*/
        {
            switch (state)
            {
            case OUT:/*The middle of the sentence*/
                if (character == '\"')
                    state = IN_STRING;
                if (character == '.')
                    state = NEW_SENTENCE;
                putchar(tolower(character));
                break;
            case NEW_SENTENCE:/*The start of a new sentence.*/
                if (character == '\"')
                    state = IN_STRING;
                else if (!(character == '.' || character == '\n' || character == ' '))
                    state = OUT;

                putchar(toupper(character));
                break;
            case IN_STRING:/*In between the double quotes.*/
                if (character == '\"')
                    state = OUT;
                putchar(toupper(character));
                break;
            }
        }

    return 0;
}