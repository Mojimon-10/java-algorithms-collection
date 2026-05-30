/* Find the First Non-Repeating Character
Problem:
Given a string, find the first character that appears only once.
If no such character exists, return:
'-'

Example 1
Input:
"leetcode"

Output:
'l'

Because:
l = 1
e = 3
t = 1
c = 1
o = 1
d = 1

The first character with frequency 1 is:
l

Example 2
Input:
"aabb"

Output:
'-'
Because every character repeats.

Example 3
Input:
"swiss"
Output:
'w'
Frequency:
s = 3
w = 1
i = 1

*/

import java.util.*;

public class nonRepeating
{
    public static char validator(String word)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < word.length(); i++) 
        {
            char current = word.charAt(i);

            if (current == ' ') 
            {
                continue;
            }
            
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        for (int i = 0; i < word.length(); i++) 
        {
            char current = word.charAt(i);

            if (current == ' ') 
            {
                continue;
            }
            
            if (map.get(current) == 1) 
            {
                return current; 
            }
        }

        return '-';   
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextLine()) 
        {
            String input = sc.nextLine().trim();
            char result = validator(input);
            
            System.out.println("Winner:");
            System.out.println("'" + result + "'");
        }
        sc.close();
    }
}