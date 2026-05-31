/*
Problem 2: The Ride-Share Fare Calculator
Description:
Imagine you are building the fare calculation engine for a ride-sharing app. 
Given the ride distance in miles ( double ), you need to compute the total 
price and print a text breakdown of how the fare was built.

Rules
1  Base Fee: Every ride has a starting Base Fee of $3.50.
2  Full Miles: Every full mile costs $2.00.
3  Partial Miles: Any fractional mile (even a tiny bit, like 0.01 miles) gets charged a flat "Partial Mile Fee" of $1.00.
4  Zero Distance: If the distance is exactly 0.0, the total price is $0.00 and nothing is charged.

Examples
Input: distance = 3.0
Calculation: Base ($3.50) + 3 Full Miles ($6.00) + 0 Partial Miles ($0.00) = $9.50
Output: Total: $9.50 (Base, Full, Full, Full)

Input: distance = 1.2
Calculation: Base ($3.50) + 1 Full Mile ($2.00) + 1 Partial Mile ($1.00) = $6.50
Output: Total: $6.50 (Base, Full, Partial)

Input: distance = 0.05
Calculation: Base ($3.50) + 0 Full Miles ($0.00) + 1 Partial Mile ($1.00) = $4.50
Output: Total: $4.50 (Base, Partial)
 */

import java.util.Scanner;

public class rideShareFare
{   
    public static void validator(float miles)
    {
        double base = 3.50;
        int fee = (int)miles * 2;
        float partial = miles % 1;

        String breakdown = "Base";

        for(int i = 0; i < (int)miles; i++)
        {
            breakdown += ", Full";
        }


        if(partial > 0)
        {
            breakdown += ", Partial";
            partial = 1;
            double payment = base + fee + partial;
            System.out.println("Total: " + "$" + payment + " (" + breakdown + ")");
        }
        
        else if(partial == 0 && miles > 0)
        {
            double payment = base + fee;
            System.out.println("Total: " + "$" + payment + " (" + breakdown + ")");
        }

        else
        {
            System.out.println("Total: $0.00");
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextFloat())
        {
            float miles = sc.nextFloat();
            validator(miles);
        }

        sc.close();
    }
}