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

public class mostFreqWord
{
    public static List<List<String>> validator(String[] s)
    {
        HashMap<String, List<String>> map = new HashMap<>();
        String winner = "";
        int count = 0;

        for(String word : s)
        {
            String lowerWord = word.toLowerCase();
            word = lowerWord.replaceAll("[\\s'.,!]", "");

            if (!map.containsKey(word))
            {
                map.put(word, new ArrayList<>());
            }
                
            map.get(word).add(word);

            if(map.get(word).size() > count)
            {
                count = map.get(word).size();
                winner = word;
            }

        }
        System.out.println(winner);
        return new ArrayList<>(map.values());
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s");
        List<List<String>> sentence = validator(words);

        System.out.println(sentence);

    }
}
