/*
Problem 8: Parking Garage Calculator

Description:
You are building the billing system for a parking garage.

Given the number of hours a vehicle was parked,
calculate the total parking fee and print a breakdown
of how the fee was calculated.

Rules

1. Entry Fee
   Every vehicle pays:
   $10

2. Full Hour Fee
   Every full hour parked costs:
   $3

3. Partial Hour Fee
   Any remaining fraction of an hour
   (even 0.01 hours)
   costs:
   $2

4. Zero Hours Rule
   If the vehicle stayed exactly:
   0.0 hours

   Charge:
   $0

   No entry fee is charged.

5. Output Format
   Print the total and breakdown.

Examples

Input:
4.0

Calculation:
Entry = 10
Full Hours = 4 × 3 = 12
Partial = 0

Output:
Total: $22
(Entry, Full, Full, Full, Full)


Input:
2.5

Calculation:
Entry = 10
Full Hours = 2 × 3 = 6
Partial = 2

Output:
Total: $18
(Entry, Full, Full, Partial)


Input:
0.25

Calculation:
Entry = 10
Full Hours = 0
Partial = 2

Output:
Total: $12
(Entry, Partial)


Input:
0.0

Output:
Total: $0


Input:
5.9

Calculation:
Entry = 10
Full Hours = 5 × 3 = 15
Partial = 2

Output:
Total: $27
(Entry, Full, Full, Full, Full, Full, Partial)


Method Signature:

public static void calculateParkingFee(double hours)
*/

import java.util.Scanner;

public class parkingGarageCalculator
{
    public static void parkingGarage(float s)
    {
        int entryFee = 10;
        int hour = (int)s * 3;
        float partial = s % 1;


        StringBuilder breakdown = new StringBuilder(); 
        breakdown.append("Entry, ");

        for(int i = 0; i < (int)s; i++)
        {
            breakdown.append("Full");
            breakdown.append(", ");
        }

        if(partial > 0)
        {
            breakdown.append("Partial");
            partial = 2;
            int payment = entryFee + hour + (int)partial;
            System.out.println("Total: " + "$" + payment);
            System.out.println("(" + breakdown + ")");
        }

        else if(partial == 0 && s > 0)
        {
            int payment = entryFee + hour;
            System.out.println("Total: " + "$" + payment);
            System.out.println("(" + breakdown + ")");
        }

        else
        {
            System.out.println("Total: $0");
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Float input = sc.nextFloat();

        parkingGarage(input);
    }
}