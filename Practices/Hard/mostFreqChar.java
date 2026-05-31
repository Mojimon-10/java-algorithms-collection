/*
Problem 5: Most Frequent Character

Description:
Given a string, find the character that appears the most times.

The method should return:
1. The character
2. How many times it appeared

Rules

1. Case Insensitive
   Uppercase and lowercase letters should be treated
   as the same character.

   Example:
   'A' and 'a' count together.

2. Ignore Spaces
   Spaces should not be counted.

3. If multiple characters have the same highest frequency,
   return the one that appears first in the string.

Examples

Input:
"banana"

Frequency:
b = 1
a = 3
n = 2

Output:
a: 3


Input:
"Hello World"

Frequency:
h = 1
e = 1
l = 3
o = 2
w = 1
r = 1
d = 1

Output:
l: 3


Input:
"AaBb"

Frequency:
a = 2
b = 2

Both have frequency 2.

Since 'a' appears first in the string:

Output:
a: 2


Input:
"     "

Output:
No valid characters found.


Method Signature:

*/

import java.util.*;

public class mostFreqChar 
{
    public static void validator(String word) 
    {
        String winner = "";
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        String cleanedWord = word.toLowerCase().replace(" ", "");

        if (cleanedWord.isEmpty()) 
        {
            System.out.println("No valid characters found.");
            return;
        }

        char[] c = cleanedWord.toCharArray();

        for (char letter : c) 
        {
            
            map.put(letter, map.getOrDefault(letter, 0) + 1);

            if (map.get(letter) > count) 
            {
                winner = String.valueOf(letter); 
                count = map.get(letter);
            }
        }

        System.out.println(winner + ": " + count);
    }

    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        validator(input);
    }
}