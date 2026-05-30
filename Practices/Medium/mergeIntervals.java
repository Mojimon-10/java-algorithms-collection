/*
Merge Intervals
Problem:
Given an array of intervals where:

intervals[i] = [start, end]
merge all overlapping intervals.

Example
Input:
[[1,3],[2,6],[8,10],[15,18]]

Output:
[[1,6],[8,10],[15,18]]
*/

import java.util.*;

public class mergeIntervals 
{
    public static int[][] merge(int[][] intervals) 
    {

        // Sort intervals based on starting value
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<int[]> merged = new ArrayList<>();

        // Start with first interval
        int[] current = intervals[0];

        // Add first interval to list
        merged.add(current);

        // Loop through remaining intervals
        for(int i = 1; i < intervals.length; i++) 
        {
            int[] next = intervals[i];

            // Check overlap
            if(next[0] <= current[1])
            {
                // Merge intervals
                current[1] = Math.max(current[1], next[1]);
            }

            else 
            {
                // Move current to next interval
                current = next;

                // Add new interval
                merged.add(current);
            }
        }

        // Convert List<int[]> into int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) 
    {

        int[][] intervals = 
        {
            {1,3},
            {2,6},
            {8,10},
            {15,18}
        };

        int[][] result = merge(intervals);

        // Print merged intervals
        for(int[] interval : result) 
        {

            System.out.println(
                "[" + interval[0] + ", " + interval[1] + "]"
            );
        }
    }
}