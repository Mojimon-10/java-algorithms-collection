/* Two Sum Problem
Problem:
Given an array of integers nums and an integer target, 
return the indices of the two numbers such that they add up to target.

You may assume:
Each input has exactly one solution.
You cannot use the same element twice.

Example
Input:
nums = [2,7,11,15]
target = 9

Output:
Solution:
[0,1]

*/

public class twoSum
{
    public static int[] validator(int[] nums, int target)
    {
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] + nums[j] == target)
                {
                    System.out.println("Solution:");
                    return new int[] {i,j};
                }
            }
        }
        System.out.println("No Solutions!");
        return null;

    }
    public static void main(String args[])
    {
        int[] nums = {2, 7, 11, 15};
        int target = 17;

        int[] results = validator(nums, target);
        System.out.println("[" + results[0] + "," + results[1] + "");
    }
}