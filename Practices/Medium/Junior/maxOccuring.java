/*
Problem: Find Maximum Occurring Character


Description:

You are given a string.

Your task is to find the character that appears
the most times in the string.



Rules:


1. Case Insensitive

Treat uppercase and lowercase as the same.

Example:

A
a
A

counts as:

a = 3



2. Ignore spaces and punctuation.


Example:

"Hello, World!"

Only count:

hello world



3. If two characters have the same highest frequency:

Return the character that appeared first.



Example:

Input:

"aabb"


Counts:

a -> 2
b -> 2


Output:

a


because a appeared first.



4. If there are no valid characters:

Return:

"No characters found."



Method Signature:


public static String maxCharacter(String input)



Examples:



Example 1:

Input:

"programming"


Count:

p -> 1
r -> 2
o -> 1
g -> 2
m -> 2
i -> 1
n -> 1


Output:

g



Example 2:

Input:

"Hello World"


Counts:

h -> 1
e -> 1
l -> 3
o -> 2
w -> 1
r -> 1
d -> 1


Output:

l



Example 3:

Input:

"123 !!!"


Output:

"No characters found."
*/

import java.util.*;

public class maxOccuring
{
    public static String maxCharacter(String input)
    {
        String s = input.toLowerCase().replaceAll("[^a-z]", "");

        HashMap<Character, Integer> map = new HashMap<>();

        String answer = "";
        int max = 0;

        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) > max)
            {
                max = map.get(c);
                answer = String.valueOf(c);
            }
        }

        if(s == null || s.trim().isEmpty())
        {
            return ("No character found");
        }
        
        return answer;
    }


    public static void main(String args[])
    {
        System.out.println(maxCharacter("programming"));
    }
}