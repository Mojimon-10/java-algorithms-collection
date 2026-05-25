/* big O notations is like a measuring tape 
it does NOT measure the speed
it measures the SCALE 
remember SCALE not SPEED

it measure how well the algorithm scales with bigger data!

*/

public class bigONotations
{

    // 1. O(1) - CONSTANT TIME
    // No matter how big the array gets, this method takes exactly ONE step.
    // It instantly jumps to the index and grabs the element.
    public static int constantTimeExample(int[] array, int index) 
    {
        return array[index]; 
    }


    // 2. O(log n) - LOGARITHMIC TIME
    // Every step cuts the array search space completely in half.
    // Used in Binary Search! Even with 1 million items, this takes max ~20 steps.
    public static int logarithmicTimeExample(int[] sortedArray, int target) 
    {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) 
        {
            int mid = low + (high - low) / 2; // Find the exact middle

            if (sortedArray[mid] == target) 
            {
                return mid; // Target found!
            } 
            
            else if (sortedArray[mid] < target) 
            {
                low = mid + 1;  // Chop away the left half
            } 
            
            else 
            {
                high = mid - 1; // Chop away the right half
            }
        }
        return -1; // Target not found
    }


    // 3. O(n) - LINEAR TIME
    // One single loop scanning from 0 to n.
    // If the array has 10 items, it loops 10 times. If 1,000 items, it loops 1,000 times.
    public static boolean linearTimeExample(int[] array, int target) 
    {
        for (int i = 0; i < array.length; i++) 
        {
            if (array[i] == target) 
            {
                return true; // Found it during the scan
            }
        }
        return false;
    }


    // 4. O(n log n) - LINEARITHMIC TIME
    // The code does a logarithmic split (chopping in half) but combines it with a linear scan.
    // This is the blueprint code setup for Merge Sort or Quick Sort.
    public static void linearithmicExample(int[] array, int low, int high) 
    {
        if (low >= high) return; // Base Case

        // 1. Logarithmic split (chopping the array in half)
        int mid = low + (high - low) / 2;
        linearithmicExample(array, low, mid);
        linearithmicExample(array, mid + 1, high);

        // 2. Linear operation (Imagine a O(n) loop merging the elements here)
        // merge(array, low, mid, high); 
    }


    // 5. O(n^2) - QUADRATIC TIME
    // A nested loop (a loop inside a loop). 
    // For every step the outer loop takes, the inner loop runs a full 'n' times.
    // If the array size is 10, this takes 100 operations (10 * 10). Dangerous for large data!
    public static void quadraticTimeExample(int[] array) 
    {
        int n = array.length;
        
        for (int i = 0; i < n; i++) 
        {         // Outer Loop runs n times
            for (int j = 0; j < n; j++) 
            {     // Inner Loop runs n times
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }
}