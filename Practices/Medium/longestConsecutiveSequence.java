
public class longestConsecutiveSequence
{
    public static int longestConsecutive(int[] nums) 
    {
        int max = 0;

        for (int x : nums) 
        {
            int current = x;
            int streak = 1;
            
            while (contains(nums, current + 1)) 
            { 
                current++; streak++; 
            }

            if (streak > max) max = streak;
        }

        return max;
    }

    private static boolean contains(int[] arr, int target) 
    {
        for (int n : arr) 
        {
            if (n == target)
            return true;
        }
        return false;
    }
    public static void main(String args[])
    {
        int[] values = {1,13,12,10,11,14,2};
        int results = longestConsecutive(values);

        System.out.println(results);

    }
}