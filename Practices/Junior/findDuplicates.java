/*
Problem: Find Duplicate Number

Description:
You are given an array of integers.
Your task is to find the FIRST number that appears more than once.
Return that duplicate number.


Rules:
1. Return the first duplicate encountered from left to right.

Example:
Input:
[1, 3, 4, 2, 3]

Scan:

1 → first time
3 → first time
4 → first time
2 → first time
3 → already exists


Output:

3

2. If there are no duplicates:
Return:
"No duplicate found."

Example:
Input:
[1,2,3,4,5]

Output:
"No duplicate found."

Method Signature:
public static String findDuplicate(int[] nums)

Test Cases:
Test 1:

Input:
[1,2,3,2,4]

Output:
2

Test 2:
Input:
[5,4,3,5,2]

Output:
5

Test 3:
Input:
[10,20,30]

Output:
"No duplicate found."

*/
import java.util.*;

public class findDuplicates
{
    public static String find(int[] i)
    {
        LinkedHashSet<Integer> seen = new LinkedHashSet<>();

        for(int number : i)
        {
            if(seen.contains(number))
            {
                return String.valueOf(number);
            }

            seen.add(number);
        }

        return ("No duplicates found");
    }
    public static void main(String args[])
    {
        int[] start = {1,2,3,1,4,5,6};
        System.out.println(find(start));

    }
}