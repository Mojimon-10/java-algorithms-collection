/*
Problem: Remove Duplicate Values

Description:

You are given an array of integers.

Your task is to remove duplicate numbers
and return only the unique values.


Rules:


1. Remove duplicates

Example:

Input:

[1,2,2,3,4,4,5]

Output:

[1,2,3,4,5]



2. Keep the original order

The first appearance stays.

Example:

Input:

[5,2,5,1,2]

Output:

[5,2,1]

NOT:

[1,2,5]


3. Empty Input

If the array is empty:

Return:

[]

Test Cases:

Test 1:

Input:

[1,2,3,2,4,1,5]

Output:

[1,2,3,4,5]


Test 2:

Input:

[5,5,5,5]

Output:

[5]

Test 3:

Input:

[]

Output:

[]

*/

import java.util.*;

public class removeDuplicates
{
    public static List<Integer> duplicates(int[] nums)
    {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int num : nums)
        {
            set.add(num);
        }

        return new ArrayList<>(set);
    }


    public static void main(String args[])
    {
        int[] input = {1,2,2,3,4,4,5};

        System.out.println(duplicates(input));
    }
}