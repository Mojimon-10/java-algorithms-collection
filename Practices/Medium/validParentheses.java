/* Valid Parentheses Problem
Problem:
Given a string containing only:
( ) { } [ ]

Determine if the input string is valid.

A string is valid if:
Open brackets are closed by the same type
Open brackets are closed in the correct order

Example 1
Input:
"()[]{}"

Output:
true

Example 2
Input:
"(]"

Output:
false
*/

import java.util.Scanner;
import java.util.Stack;

public class validParentheses
{
    public static boolean validator(String input)
    {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);

            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            
            else if(c ==')' || c == '}' || c == ']')
            {
                if(stack.empty())
                {
                    return false;
                }

                char top = stack.pop();

                if( (c  ==')' && top != '(') ||
                    (c  =='}' && top != '{') ||
                    (c  ==']' && top != '[') )
                {
                    return false;
                }

            }
        }

        return stack.empty();
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean results = validator(s);
        System.out.print(results);
        
        sc.close();
    }
}