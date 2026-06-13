import java.util.*;

class practice
{
    public static String findDuplicate(int[] nums)
    {
        HashSet<Integer> seen = new HashSet<>();

        for(int num : nums)
        {
            if(seen.contains(num))
            {
                return String.valueOf(num);
            }

            seen.add(num);
        }

        return "No duplicates found.";
    }


    public static void main(String args[])
    {
        int[] input = {1, 2, 3, 4, 5, 1, 2};

        System.out.println(findDuplicate(input));
    }
}