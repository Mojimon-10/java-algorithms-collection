/*
Longest Substring Without Repeating Characters

Problem:
Given a string s, find the length of the longest substring without repeating characters.

Example 1
Input:
"abcabcbb"

Output:
abc

Explanation:
"abc" is the longest substring without repeating characters.
*/

import java.util.Scanner;

public class longestSubstring 
{
    public static String LongestSubstring(String s)
    {
        String longest = "";

        for(int i = 0; i < s.length(); i++)
        {
            String current = "";

            for(int j = 0; j < s.length(); j++)
            {
                char c = s.charAt(j);

                if(current.contains(Character.toString(c)))
                {
                    break;
                }

                current += c;

                if(current.length() > longest.length())
                {
                    longest = current.strip();
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String result = LongestSubstring(input);

        System.out.println("Original String: " + input);
        System.out.println("Longest String: " + result);
        System.out.println("Length: " + result.length());

        sc.close();

    }
}