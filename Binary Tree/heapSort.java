/*
 HEAP SORT ALGORITHM 
1. Complete Binary Tree: Levels are filled left-to-right; no missing gaps.
2. Max-Heap Rule: Parent node value MUST be >= its children's values.
Result -> The absolute maximum value is ALWAYS sitting at index 0.

POINTERLESS ARRAY INDEX MATH
Given any parent element sitting at index 'i':
Left Child Index  = 2 * i + 1
Right Child Index = 2 * i + 2
Parent Index      = (i - 1) / 2

THE 2-PHASE GAMEPLAN
PHASE 1: Build Heap (Heapify Upwards)
Loop backward from the last non-leaf node (n/2 - 1) up to index 0.
Run three-way showdowns (Parent vs Left vs Right) to force the
largest numbers to crawl up to the top.

PHASE 2: Extract & Swap (Sort Downwards)
Loop backward from the end of the array (n - 1) down to 1.
SWAP index 0 (current max) with index 'i' (current end of active tree).
SHRINK active tree boundary size by 1 (locking the max value in place).
HEAPIFY down from index 0 to sink the swapped element and float the 
next maximum number back up to the root.

Time Complexity (Best/Avg/Worst): O(n log n)
 */
public class heapSort 
{
    public void sort(int[] arr) 
    {
        int n = arr.length;

        // PHASE 1: Build the Max-Heap (Rearrange the raw array)
        // We start at the last non-leaf node and work backward to index 0
        for (int i = n / 2 - 1; i >= 0; i--) 
        {
            heapify(arr, n, i);
        }

        // PHASE 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) 
        {
            // 1. Move the current maximum (at index 0) to the very end of the array
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 2. Call heapify on the remaining, smaller tree to float the next max to index 0
            heapify(arr, i, 0);
        }
    }

    // The core engine: Fixes a subtree to ensure it follows the parent >= child rule
    private void heapify(int[] arr, int size, int rootIndex) 
    {
        int largest = rootIndex;       // Assume the parent node is the largest for now
        int left = 2 * rootIndex + 1;  // Formula to find the left child index
        int right = 2 * rootIndex + 2; // Formula to find the right child index

        // Showdown Part 1: Is the Left child inside the tree bounds and larger than the root?
        if (left < size && arr[left] > arr[largest]) 
        {
            largest = left;
        }

        // Showdown Part 2: Is the Right child inside tree bounds and larger than our current winner?
        if (right < size && arr[right] > arr[largest]) 
        {
            largest = right;
        }

        // If a child won the showdown, we have a violation! We must swap.
        if (largest != rootIndex) 
        {
            int swap = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected lower branch to make sure it didn't break down the line
            heapify(arr, size, largest);
        }
    }

    // Utility method to print the array
    public static void printArray(int[] arr) 
    {
        for (int value : arr) 
        {
            System.out.print(value + " ");
        }
        
        System.out.println();
    }

    // Test execution
    public static void main(String[] args) 
    {
        int[] arr = {19, 7, 15, 3, 11, 2};

        System.out.print("Unsorted Input Array: ");
        printArray(arr);

        heapSort start = new heapSort();
        start.sort(arr);

        System.out.print("Final Sorted Array:   ");
        printArray(arr); // Expected Output: 2 3 7 11 15 19
    }
}