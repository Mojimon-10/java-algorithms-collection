/* Remember binary search's divide and conquer?
Well, merge sort works like that, but it is a SORTING algorithm.
with the use of recursion.

For example, you need to sort this messy array:
8 7 3 5 3 2 0 1 

----------------------------------------------------------------------
PHASE 1: THE DOWN PHASE (Divide)
The algorithm keeps chopping the arrays exactly in half using recursion 
until every single number is isolated in its own box (Base Case).
----------------------------------------------------------------------
8 7 3 5 | 3 2 0 1
8 7 | 3 5 | 3 2 | 0 1
8 | 7 | 3 | 5 | 3 | 2 | 0 | 1   <-- Base case reached! (1 item = sorted)

----------------------------------------------------------------------
PHASE 2: THE UP PHASE (Conquer & Merge)
Now, values are compared and merged into NEW sorted pairs.
We don't "swap" in place; we zip separate piles together in order.
----------------------------------------------------------------------

STEP 1: Merge individual boxes into sorted pairs of 2:
(Compare 8 & 7) -> 7 8
(Compare 3 & 5) -> 3 5
(Compare 3 & 2) -> 2 3
(Compare 0 & 1) -> 0 1
Resulting pairs: [7, 8] | [3, 5] | [2, 3] | [0, 1]

STEP 2: Merge pairs of 2 into sorted groups of 4:
(Merge [7, 8] and [3, 5]) -> 3 5 7 8
(Merge [2, 3] and [0, 1]) -> 0 1 2 3
Resulting halves: [3, 5, 7, 8] | [0, 1, 2, 3]

STEP 3: The Grand Finale! Zip the two sorted halves into the final array:
(Compare the fronts of both halves and grab the smallest number step-by-step)
-> Compare 3 and 0 -> Take 0
-> Compare 3 and 1 -> Take 1
-> Compare 3 and 2 -> Take 2
-> Compare 3 and 3 -> Take 3
-> Compare 5 and 3 -> Take 3
-> Take the rest: 5, 7, 8

FINAL SORTED OUTPUT:
0 1 2 3 3 5 7 8

*/

public class mergeSort 
{

    public static void mergeSort(int[] array) 
    {
        int length = array.length;
        
        // THE BASE CASE (The Stop Button)
        if (length < 2)
        {
            return; 
        }

        // THE CHOP (Find the middle)
        int mid = length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        // NEW: COPY DATA INTO THE SUB-ARRAYS
        for (int i = 0; i < mid; i++) 
        {
            leftArray[i] = array[i];
        }
        for (int i = mid; i < length; i++) 
        {
            rightArray[i - mid] = array[i];
        }

        // THE RECURSIVE STEP (The Self-Calls)
        mergeSort(leftArray);  // Digs into the left box-inside-a-box
        mergeSort(rightArray); // Digs into the right box-inside-a-box

        // THE ZIPPER (Climbing back up to combine them)
        merge(array, leftArray, rightArray);
    }

    // NEW: THE MERGE HELPER METHOD
    private static void merge(int[] array, int[] leftArray, int[] rightArray) 
    {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        // Pointers to keep track of our position in each array
        int i = 0; // Tracks leftArray
        int j = 0; // Tracks rightArray
        int k = 0; // Tracks the original main array

        // Walk through both arrays, compare the fronts, and grab the smallest
        while (i < leftLength && j < rightLength) 
        {
            if (leftArray[i] <= rightArray[j]) 
            {
                array[k] = leftArray[i];
                i++; // Move pointer forward in left array
            } 
            
            else 
            {
                array[k] = rightArray[j];
                j++; // Move pointer forward in right array
            }
            
            k++; // Move forward in the main target array
        }

        // CLEAN-UP SQUADS: If one array ran out of numbers first, 
        // copy any leftover elements from the other array automatically.
        while (i < leftLength) 
        {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        
        while (j < rightLength) 
        {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Quick test to see it in action!
    public static void main(String[] args) 
    {
        int[] numbers = {8, 7, 3, 5, 3, 2, 0, 1};
        
        System.out.println("Before Merge Sort:");
        printArray(numbers);

        mergeSort(numbers);

        System.out.println("\nAfter Merge Sort:");
        printArray(numbers);
    }

    private static void printArray(int[] array) 
    {
        for (int num : array) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}