/* 
Shell Sort is an optimization of INSERTION SORT.
Instead of comparing neighbors (interval of 1) right away, 
it compares elements based on a larger "interval" or "gap".

For example, with an array of 9 elements and an interval of 4:
4 5 2 3 1 6 2 8 9
^       ^
  ^       ^
    ^       ^ 

It jumps or "teleports" numbers across the array based on the interval.
This allows small numbers to move huge distances very quickly.

The interval keeps cutting in half (4 -> 2 -> 1) until the interval is ONE.
When the interval is 1, it performs a standard Insertion Sort for a 
"last look" to clean up any remaining out-of-order pieces. 
Because the numbers are already close to where they belong, this final 
pass is lightning fast!
*/

public class shellSort 
{

    public static void shellSort(int[] array) 
    {
        int n = array.length;

        // Start with a big gap, then reduce the gap size by half every time
        for (int gap = n / 2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            for (int i = gap; i < n; i++) 
            {
                int temp = array[i];
                int j;
                
                // Shift earlier gapped elements up until the correct location for array[i] is found
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) 
                {
                    array[j] = array[j - gap];
                }
                
                // Put temp (the original element) in its correct slot
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) 
    {
        int[] numbers = {8, 7, 3, 5, 3, 2, 0, 1};
        shellSort(numbers);
        
        // Output: 0 1 2 3 3 5 7 8
        for (int num : numbers) 
        {
            System.out.print(num + " ");
        }
    }
}