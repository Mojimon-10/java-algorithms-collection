/*
QUICK SORT: THE PIECE-BY-PIECE RECURSIVE SORT
Quick Sort is a Divide and Conquer algorithm that sorts "in-place" 
(inside the original array) using zero extra memory overhead.

HOW IT WORKS AT RUNTIME:
1. THE CHOSEN ONE (The Pivot):
   The computer selects ONE random number from the current box to be 
   the Pivot. 

2. THE PARTITION (Left vs Right):
   It scans the box. Every number smaller than the pivot gets thrown 
   to the LEFT. Every number bigger gets thrown to the RIGHT.

3. THE HOMECOMING:
   The Pivot is placed right in the middle of the Left and Right camps.
   The Pivot is now LOCKED into its permanent, final sorted position.

4. THE CHAIN REACTION (Recursion):
   The computer now treats the Left camp as a brand new box, and the 
   Right camp as another brand new box. 
   - It goes to the Left box -> picks ONE new pivot -> divides it.
   - It goes to the Right box -> picks ONE new pivot -> divides it.

THE GRAND FINALE:
Because every single pivot is carefully placed exactly between numbers 
smaller than it and numbers bigger than it, there is NO MERGING REQUIRED. 
Once the smallest boxes hit 1 element (Base Case), the entire array 
is magically sorted!

example: [2, 9, 1, 0, 4, 8, 5, 7, 2, 9, 8, 10, 23, 2 ] random pivot is 5 it goes
is thru the line asking is 5 > i then once it is it goes to the left side if not it goes to the right side
once done it goes thru right in the MIDDLE IT WILL NOT MOVE THERE.

here new pivot it will start sorting the leftside; then after it goes right side for new pivot
[ 2, 1, 0, 4, 2, 2 ]  |  5 (LOCKED IN)  |  [ 9, 8, 7, 9, 8, 10, 23 ]
    (LEFT SIDE)             (MIDDLE)                (RIGHT SIDE)
    
[ 1, 0 ]  |  2, 2, 2 (LOCKED IN)  |  [ 4 ] (2 < ---new pivot)
[ 8, 7, 8 ]  |  9, 9 (LOCKED IN)  |  [ 10, 23 ] (9<--- new pivot)

*/

import java.util.Random;

public class quickSort 
{

    // The main method that users call
    public static void quickSort(int[] array) 
    {
        quickSort(array, 0, array.length - 1);
    }

    // The recursive method that handles the bounds of our current "box"
    private static void quickSort(int[] array, int low, int high) 
    {
        // BASE CASE: If the box has 1 or 0 elements, it's already sorted!
        if (low >= high) 
        {
            return;
        }

        // THE PARTITION: Pick a random pivot, shuffle elements, 
        // and get the final locked-in index of that pivot.
        int pivotIndex = partition(array, low, high);

        // THE LEFT DIVE: Sort everything to the left of the pivot first
        quickSort(array, low, pivotIndex - 1);

        // THE RIGHT DIVE: After the left side is 100% finished, sort the right side
        quickSort(array, pivotIndex + 1, high);
    }

    // The "Wall Shifter" method that does the physical swapping
    private static int partition(int[] array, int low, int high) 
    {
        // Pick a random index between 'low' and 'high'
        Random rand = new Random();
        int randomPivotIndex = rand.nextInt(high - low + 1) + low;

        // Move the random pivot out of the way by swapping it to the very end
        swap(array, randomPivotIndex, high);
        
        int pivot = array[high]; // Our pivot value is now safely at the end
        int wall = low;          // The wall starts at the beginning of the box

        //Scan through the line: asking "Is the pivot > current element?"
        for (int i = low; i < high; i++) 
        {
            if (array[i] <= pivot) 
            {
                // If it's smaller or equal, throw it behind the wall and move the wall up
                swap(array, i, wall);
                wall++;
            }
        }

        // THE HOMECOMING: Swap the pivot from the end into its true home (the wall)
        swap(array, wall, high);

        // Return the wall position so the recursive steps know where the middle is!
        return wall; 
    }

    // Simple helper method to swap two elements in the array
    private static void swap(int[] array, int index1, int index2) 
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] array) 
    {
        for (int num : array) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Test method using your exact large array example!
    public static void main(String[] args) 
    {
        int[] numbers = {2, 9, 1, 0, 4, 8, 5, 7, 2, 9, 8, 10, 23, 2};

        System.out.println("Before Quick Sort:");
        printArray(numbers);

        quickSort(numbers);

        System.out.println("\nAfter Quick Sort:");
        printArray(numbers);
    }
}