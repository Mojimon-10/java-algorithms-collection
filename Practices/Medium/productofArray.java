/* Product of Array Except Self
Problem:
Given an integer array nums, return an array answer such that:

answer[i] = product of all elements except nums[i]
You cannot use division.

Example:
Input:
nums = [1,2,3,4]

Output:
[24,12,8,6]

Explanation:
answer[0] = 2 × 3 × 4 = 24
answer[1] = 1 × 3 × 4 = 12
answer[2] = 1 × 2 × 4 = 8
answer[3] = 1 × 2 × 3 = 6 
*/

public class productofArray
{
    public static int[] productExceptSelf(int[] nums)
    {
        int[] results = new int[nums.length];

        for(int i = 0; i < nums.length; i++)
        {
            int product = 1;
            for(int j = 0; j < nums.length; j++)
            {
                if(j != i)
                {
                    product *= nums[j];
                }

            }
            results[i] = product;
        }

        return results;
    }

    public static void main(String args[])
    {
        int[] values = {1, 2, 3, 4};
        int[] results = productExceptSelf(values);

        for(int num : results)
        {
            System.out.print("[" + num + "]" + " ");
        }
    }
}