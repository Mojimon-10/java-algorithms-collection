/* Problem 1: Most Frequent Word

Description:
Given a string of text, write a method to find the word that appears the highest 
number of times. The method should return both the word and how many times it occurred.
 
Rules & Edge Cases:
Case Sensitivity: The check should be case-insensitive (e.g., "The" and "the" 
should count as the same word).
Punctuation: Ignore punctuation attached to words (e.g., "world," or "hello!" 
should be counted simply as "world" and "hello").

Example:
    Input: "the cat chased the mouse and the mouse ran away"
    Output: the: 3
    (Explanation: "the" appears 3 times, "mouse" appears 2 times, and all other words appear 1 time.)
*/

import java.util.*;

public class mostFreqWord2
{
    public static void validator(String s)
    {
        HashMap<String, Integer> map = new HashMap<>();

        String winner = "";
        int maxCount = 0;

        String[] words = s.toLowerCase()
                          .replaceAll("[^a-z0-9\\s]", "")
                          .split("\\s+");

        for(String word : words)
        {
            map.put(word, map.getOrDefault(word, 0) + 1);

            if(map.get(word) > maxCount)
            {
                maxCount = map.get(word);
                winner = word;
            }
        }

        System.out.println(winner + ": " + maxCount);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNextLine())
        {
            String input = sc.nextLine();
            validator(input);
        }

        sc.close();
    }
}