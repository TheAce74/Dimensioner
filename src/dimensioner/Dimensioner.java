package dimensioner;

import java.util.Scanner;

/* The area is given in all cases, length is always more than breadth in a rectangle
   Input: Area, length or breadth or a relationship between the two
   Expected Output: Dimensions
   
   There are only three possible cases:
   Case 1: length or breadth is given, find the unknown one and return the result
   Case 2: length is x meters more than breadth, make calculations and return result
   Case 3: length is y times the breadth i.e. the length is a multiple of the breadth, make calculations and return result

   Computing with static values like an area of 40 isn't necessary in a dynamic app, since we are taking the user input anyway
   I used double as the default numeric type for all calculations so as to make the console app scalable
*/

public class Dimensioner {
    static double area;
    
    public static void main(String[] args) {
        System.out.println("Welcome Sarah");
        
        System.out.println("Select the condition that defines your current project \nThe area is assumed to be available in every case");
        System.out.println("Case 1: Either length or breadth is available");
        System.out.println("Case 2: The length should be x metres more than the breadth");
        System.out.println("Case 3: The length should be y times the breadth");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the area of the garden");
        area = scanner.nextDouble();
        System.out.println("Enter case number i.e. 1-3");
        int condition = scanner.nextInt();
        
        switch(condition) {
            case 1 -> {
                System.out.println("Enter the length or breadth of the garden");
                double dimension = scanner.nextDouble();
                getDimension(dimension);
            }
            case 2 -> {
                System.out.println("The length is x metres more than the breadth, enter the value of x");
                double x = scanner.nextDouble();
                QuadraticSolver dimensionResolver = new QuadraticSolver(1, x, -1 * area);
                getDimension(dimensionResolver.solveEquation());
            }
            case 3 -> {
                System.out.println("The length is y times the breadth, enter the value of y");
                double y = scanner.nextDouble();
                QuadraticSolver dimensionResolver = new QuadraticSolver(y, 0, -1 * area);
                getDimension(dimensionResolver.solveEquation());
            }
            default -> System.out.println("Condition Unavaliable");
        }
    }
    
    static void printResult(double length, double breadth) {
        System.out.println("The dimensions of a garden with an area of " + area + " are a length of " + length + " and a breadth of " + breadth);
    }
    
    static void getDimension(double dimension) {
        double other = area / dimension;
        if (other > dimension) {
            printResult(other, dimension);
        } else {
            printResult(dimension, other);
        }
    }
}
