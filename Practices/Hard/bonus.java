/*
Problem 3: Employee Bonus Calculator

Description:
You are building a payroll system.

Given an employee's years of service and performance rating,
calculate their bonus and print a breakdown of how the bonus
was calculated.

Rules

1. Base Bonus
   Every employee starts with:
   $500

2. Years of Service Bonus
   For every full year worked:
   +$100

   Example:
   3 years = +$300

3. Performance Bonus

   If performance rating is:
   "Excellent"
   add:
   +$1000

   If performance rating is:
   "Good"
   add:
   +$500

   If performance rating is:
   "Average"
   add:
   +$0

4. New Employee Rule

   If years of service is:
   0

   the employee receives:
   $0

   regardless of rating.

Examples

Input:
Years: 5
Rating: Excellent

Calculation:
Base = 500
Service = 500
Performance = 1000

Output:
Total Bonus: $2000
(Base, Service, Service, Service, Service, Service, Excellent)


Input:
Years: 2
Rating: Good

Calculation:
Base = 500
Service = 200
Performance = 500

Output:
Total Bonus: $1200
(Base, Service, Service, Good)


Input:
Years: 1
Rating: Average

Calculation:
Base = 500
Service = 100
Performance = 0

Output:
Total Bonus: $600
(Base, Service)


Input:
Years: 0
Rating: Excellent

Output:
Total Bonus: $0


Method Signature:

public static void calculateBonus(int years, String rating)
*/

import java.util.Scanner;

public class bonus
{
    public static void calculator(int years, String performance)
    {
        int base = 500;
        int yrs = 0;
        int bonus = 0;
        String breakdown = "";

        for(int i = 0; i < years; i++)
        {
            yrs += 100;
            breakdown += "Service ";
        }

        if(performance.equalsIgnoreCase("Average"))
        {
            bonus = 0;
            breakdown += "Average";
        }

        if(performance.equalsIgnoreCase("Good"))
        {
            bonus = 500;
            breakdown += "Good";
        }

        if(performance.equalsIgnoreCase("Excellent"))
        {
            bonus = 1000;
            breakdown += "Excellent";
        }

        int total = base + yrs + bonus;

        System.out.println("Total Bonus: " + "$" + total + " (" + breakdown + ")");
    }
    public static void main(String args[])
    {
        System.out.println("Years: ");
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextInt())
        {
            int years = sc.nextInt();
            System.out.println("Rating: ");

            sc.nextLine();
            String performance = "";
            boolean isValidRating = false;

           while (!isValidRating) 
           {
                System.out.println("Rating (Average, Good, Excellent): ");
                performance = sc.nextLine().trim().toLowerCase();

                if (performance.equalsIgnoreCase("good") || performance.equalsIgnoreCase("excellent") || performance.equalsIgnoreCase("average")) 
                {
                    isValidRating = true;
                } 
                            
                else 
                {
                    System.out.println("Invalid rating! Please try again.");
                }
            }

            calculator(years, performance);
        }
    }
}