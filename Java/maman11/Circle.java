// Comment -Good work!

/*
 * Autor: Tomer Dore
 * @version 16/03/19
 * ID number: 311309165
 * This program calculates the area and the perimeters of the excircle 
and the incircle of given rectangle 
 */
import java.util.Scanner;
public class Circle 
{
    public static void main (String [] args) 

    {
        Scanner scan = new Scanner (System.in);

        //information about the program to user
        System.out.println("This program calculates the area and the perimeters of the excircle"+ 
            " and the incircle of given rectangle.");

        int leftUpX,leftUpY, rightDownX,rightDownY; 

        //instruction to user and input the coordinates of the user
        System.out.println("please insert the two coordinates of the left upper point: ");
        leftUpX = scan.nextInt();
        leftUpY = scan.nextInt();

        System.out.println("please insert the two coordinates of the right down point: ");
        rightDownX = scan.nextInt();
        rightDownY = scan.nextInt();

        //prossing the Incircle and Excircle by calculation, using the user input  
        double inRadius, inArea, inPerimeter,distance, exRadius, exArea, exPerimeter;

        inRadius = Math.abs(leftUpY-rightDownY)/ 2.0;
        inArea = Math.PI * Math.pow(inRadius,2.0);
        inPerimeter = 2.0 * Math.PI * inRadius;

        distance = Math.sqrt(Math.pow((leftUpX-rightDownX),2.0) + Math.pow((leftUpY-rightDownY),2.0));
        exRadius = distance/2.0;
        exArea = Math.PI * (Math.pow(exRadius,2.0));
        exPerimeter = 2.0 * Math.PI * exRadius;

        //output
        System.out.println("Incircle: radius = "+inRadius+" area = "+inArea+" perimeter = "+inPerimeter);
        System.out.println("Excircle: radius = "+ exRadius+" area = "+exArea+" perimeter= "+exPerimeter);

    }
}
