import java.util.*;

public class fourSum 
{
    public static List<List<Integer>> fourSum(int[] nums, int target) 
    {
        if (nums == null || nums.length < 4) 
        {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) 
        {
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) 
            {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) 
                {
                    continue;
                }

                // 4. Set up the two pointers for the remaining space
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) 
                {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) 
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values for the third number
                        while (left < right && nums[left] == nums[left + 1]) 
                        {
                            left++;
                        }

                        // Skip duplicate values for the fourth number
                        while (left < right && nums[right] == nums[right - 1]) 
                        {
                            right--;
                        }

                        // Move both pointers inward
                        left++;
                        right--;
                    } 

                    else if (sum < target) 
                    {
                        left++; // Sum is too small, move left pointer to get a larger number
                    } 

                    else 
                    {
                        right--; // Sum is too big, move right pointer to get a smaller number
                    }
                }
            }
        }

        return result;
    }

    public static void main(String args[]) 
    {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> results = fourSum(nums, target);
        
        // Print the result to verify it works
        System.out.println(results);
    }
}