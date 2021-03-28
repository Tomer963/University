/*
* Autor: Tomer Dore
* @version 16/03/19
* ID number: 311309165
* This program solves a system of 2 linear equations with user choosen numbers
*/
// Comment - your emthod doesn't work ok for the following cases  -12 points
// ----******-----Equations Test 4: Equations04.txt----******-----

// Input:
// a11 = 0, a12 = 0, b1 = 0
// a21 = 1, a22 = 2, b2 = 3

// Expected Output: 
// Eq1: 0*x1+0*x2=0
// Eq2: 1*x1+2*x2=3
// Many solutions

// Student Output: 
// Eq1:0*x1+0*x2=0
// Eq2:1*x1+2*x2=3
// No solution

// FAILED!!!
// ----******-----Equations Test 12: Equations12.txt----******-----

// Input:
// a11 = 2, a12 = 5, b1 = -1
// a21 = -10, a22 = -25, b2 = 5

// Expected Output: 
// Eq1: 2*x1+5*x2=-1
// Eq2: -10*x1+-25*x2=5
// Many solutions

// Student Output: 
// Eq1:2*x1+5*x2=-1
// Eq2:-10*x1+-25*x2=5
// No solution

// FAILED!!!
import java.util.Scanner;
public class Equations
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner (System.in);
        int a11,a12,a21,a22,b1,b2; 
        final int MAX=1000;/* dispalys the amount of numbers 
        after the decimal point. possible to add or subtract zero/s to change displays */

        //Explanation about the program, instruction and user input 
        System.out.println("This program solves a system of 2 linear equations:");
        System.out.println("Enter the coefficients a11 a12 a21 b1 b2");
        a11 = scan.nextInt();
        a12 = scan.nextInt();
        a21 = scan.nextInt();
        a22 = scan.nextInt();
        b1 = scan.nextInt();
        b2 = scan.nextInt();

        //show the 2 equations include the coefficients that choosen by user
        System.out.println("Eq1:"+a11+"*x1+"+a12+"*x2="+b1);
        System.out.println("Eq2:"+a21+"*x1+"+a22+"*x2="+b2);

        /*processing (by calculating) the choosen numbers with equations conditions 
        below and output results to user*/ 
        double firstCalculation,secondCalculation,firstSolution,secondSolution;

        firstCalculation = ((b1*a22)-(b2*a12))/(double)((a11*a22)-(a12*a21));
        firstSolution=Math.round(firstCalculation*MAX)/(MAX*1.0);//round firstsolution to 3 numbers after decimal point

        secondCalculation = ((b2*a11)-(b1*a21))/(double)((a11*a22)-(a12*a21)); 
        secondSolution=Math.round(secondCalculation*MAX)/(MAX*1.0);//round secondsolution to 3 numbers after decimal point

        //equations conditions section
        if((a11*a22)-(a12*a21)!=0) 
            System.out.println("Single solution:("+firstSolution+","+secondSolution+")");
        else if(((b2*a11)-(b1*a21) ==0) && ((b1*a22)-(b2*a12)==0) && (a11==0 && a12==0 && b1==0) 
        && (a21==0 && a22==0 && b2==0))
            System.out.println("Many solution");
        else 
            System.out.println("No solution");
    }
}   