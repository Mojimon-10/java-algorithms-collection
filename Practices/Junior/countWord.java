/*
Problem: Count Word Frequency
Description:

You are given a sentence containing multiple words.

Your task is to count how many times each word appears.

Rules:

1. Case Insensitive

Words with different capitalization are treated as the same.
Example:

Java
JAVA
java

all become:

java

2. Ignore Punctuation

Remove punctuation before counting.

Example:

hello!
hello.
hello,

all become:

hello

3. Return the Frequency Count

Store each word and how many times it appears.

Format:

word: count

Example:

Input:

"Java is fun. Java is powerful. JAVA is popular"


Output:

java: 3
is: 3
fun: 1
powerful: 1
popular: 1



4. Empty Input

If no valid words exist:

Return:

"No words found."



Method Signature:

public static String countWordFrequency(String sentence)



Test Cases:


Test 1:

Input:

"cat dog cat bird dog cat"


Output:

cat: 3
dog: 2
bird: 1



Test 2:

Input:

"Hello, hello HELLO"


Output:

hello: 3



Test 3:

Input:

""


Output:

No words found.



Hint:

Think:

Need:

word -> count


Data Structure:

HashMap<Key, Integer>

*/

import java.util.*;

public class countWord
{
    public static String count(String s)
    {
        String[] cleaned = s.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        for(String x : cleaned)
        {
            if(x == null || x.trim().isEmpty())
            {
                continue;
            }

            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return map.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext())
        {
            String input = sc.nextLine();
            System.out.println(count(input));
        }

        sc.close();
    }
}