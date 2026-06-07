/*
Problem 2: Product Rating Display

Description:
You are building the rating display system for an e-commerce website.

Given a product rating from 0.0 to 5.0, generate a visual
rating breakdown using:

FULL
HALF
EMPTY

Rules

1. Maximum Stars
   Every product must display exactly:
   5 positions

2. Round Rating
   Round the rating to the nearest:
   0.5

3. Full Star
   Every whole number contributes:
   FULL

4. Half Star
   A remaining 0.5 contributes:
   HALF

5. Empty Star
   Remaining positions become:
   EMPTY

6. Output Format
   Return the result joined by:

   " | "

Examples

Input:
4.3

Rounded:
4.5

Output:
FULL | FULL | FULL | FULL | HALF


Input:
3.8

Rounded:
4.0

Output:
FULL | FULL | FULL | FULL | EMPTY


Input:
2.2

Rounded:
2.0

Output:
FULL | FULL | EMPTY | EMPTY | EMPTY


Input:
0.5

Output:
HALF | EMPTY | EMPTY | EMPTY | EMPTY


Input:
0.0

Output:
EMPTY | EMPTY | EMPTY | EMPTY | EMPTY


Input:
5.0

Output:
FULL | FULL | FULL | FULL | FULL
*/

import java.util.Scanner;

public class ratingDisplay
{
    public static String displayRating(double rating)
    {
        StringBuilder result = new StringBuilder();
        double rounded = Math.round(rating * 2.0) / 2.0;

        for(int i = 0; i < 5; i++)
        {
            if(rounded >= 1)
            {
                result.append("FULL");
                rounded -= 1;
            }

            else if(rounded == 0.5)
            {
                result.append("HALF");
                rounded -= 0.5;
            }

            else
            {
                result.append("EMPTY");
            }

            if(i < 4)
            {
<<<<<<< HEAD
                result.append(" | ");
=======
                 result.append(" | ");
>>>>>>> ef08c3573181e2f73cd2233832ffe6076f1cc180
            }
        }

        String result2 = result.toString();
        return result2;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Double rate = sc.nextDouble();

        System.out.println(displayRating(rate));

        sc.close();
    }
}