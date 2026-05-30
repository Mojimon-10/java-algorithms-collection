/* 
Problem
Given an array of strings, group the anagrams together.
Anagrams are words that contain the same letters but in different orders.

Example
Input:
["eat","tea","tan","ate","nat","bat"]

Output:
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]

*/

import java.util.*;

public class anagrams 
{
    public static List<List<String>> groupAnagrams(String[] words)
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String sentence : words)
        {
            char[] c = sentence.toCharArray();
            Arrays.sort(c);

            String sortedWord = new String(c);

            if(!map.containsKey(sortedWord))
            {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(sentence);
        }

        return new ArrayList<>(map.values());
    }

    public static void main (String args[])
    {
        String[] words = {"word", "eat", "tea", "ate", "dear", "read"};
        List<List<String>> results = groupAnagrams(words);

        System.out.println(results);

    }
}