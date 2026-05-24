class searchAndSortingAlgo
{
    private int[] array = new int[50];
    private int arraySize = 10;
    
    public void generateArray()
    {
        for(int i = 0; i < arraySize; i++)
        {
            array[i] = (int)(Math.random()*10)+10;
        }
    }
    
    public void printArray()
    {
        for(int i = 0; i < arraySize; i++)
        {
            System.out.println(i);
            System.out.println(array[i]);
            System.out.println("---------------");
        }
    }
    
    public String linearSearch(int value)
    {
        boolean doesExist = false;
        String indexWithValue = "";
        
        for(int i = 0; i < arraySize; i++)
        {
            if(array[i] == value)
            {
                doesExist = true;
                indexWithValue += i + " ";
            }
        }

        if(doesExist)
        {
            return "Values is stored in index(s): " + indexWithValue;
        }
        
        return "No values exist within the array.";

    }
	
	
   public void binarySeacrh(int value)
    {
		//binary search is divide and conquer
		//we need the array to be sorted in order to effectively use this binary search
		// so it will have 2 index pointer
		// the low will start is index zero
        int lowIndex = 0;
		//then high pointer will be at the top
        int highIndex = arraySize - 1;
        boolean found = false;
        
        while(lowIndex <= highIndex)
        {
            int middleIndex = (highIndex + lowIndex) / 2;

            if(array[middleIndex] < value) 
            {
                lowIndex = middleIndex + 1; // Added + 1 so it skips the mid slot
            }
        
            // If the middle value is too big, look at the lower left half
            else if(array[middleIndex] > value) 
            {
                highIndex = middleIndex - 1; // Added - 1 so it skips the mid slot
            }
 
            // If it isn't higher, and it isn't lower, we found an exact match!
            else 
            {
                System.out.println("Found a Match for " + value + " at Index " + middleIndex);
                found = true;
                // Break out of the loop since we found it
                lowIndex = highIndex + 1; 
            }
			
			
        }
        
    }
    
	// SORTING ALGO
	
    //bubble sort checks 2 data at a time.
	//so it goes back to the start to check again
	// |2||5||2||1| 
	// |2||5| so it checks this first then
	// 	  |5||2| it checks this and see that it is 5>2 so it swaps
	// |2||2||5||1| then it checks the 5 3
	// |2||2||1|5| the goes back to the starting index which is 2
	// |2||2||1||5|
    // |2||1||2||5| it swaps 2 and 1
	// |2||1||2|5| then checks 2 and 5 and goes back again at index 0
	// |1||2||2||5| it then checks the whole line
    public void bubbleSort()
    {
        for(int i = arraySize - 1; i > 1; i--)
        {
            for(int j = 0; j < i; j++)
            {
                if(array[j] > array[j + 1])
                {
                    swapValues(j, j+1);
                }
            }
        }
    }
	
	// the swap values; where it will receive the data 
    public void swapValues(int indexOne, int indexTwo)
    {
		// imagine like a cup where we need a temporary holder of that liquid you cannot just pour at 2 filled cups at the same time at each other.
		// so the temporary holder will have the value of the index one
        int temp = array[indexOne];
		//then the indexOne is now emptry this will receieve the value of indexTwo
        array[indexOne] = array[indexTwo];
		//then indexTwo is now empty, the data of the temp will then be given to indexTwo
        array[indexTwo] = temp;
    }
    
    
    public void selectionSort()
    {
        // x is the spot in the array we are currently trying to fill
        for(int x = 0; x < arraySize; x++)
        {
            
            // Assume the current spot x has the smallest value for now
            int minimum = x;
            
            // y scans the rest of the array to find if a smaller number exists
            for(int y = x; y < arraySize; y++)
            {
                // If we find a number smaller than our current minimum...
                if(array[minimum] > array[y])
                {
                    
                    // ...remember this new position as the new minimum!
                    minimum = y;
                }
            }
            // After scanning the whole line, swap the smallest item into spot x
            swapValues(x, minimum);
        }
    }
    
	
    public void insertionSort()
    {  
        for(int i = 1; i < arraySize; i++)
        {
            int j = i;
            int toInsert = array[i];
            
            while((j > 0) && (array[j-1] > toInsert))
            {
                array[j] = array[j-1];
                j--;
            }

            array[j] = toInsert;
        }
    }
    
    public static void main(String[] args) 
    {
        Main start = new Main();
        start.generateArray();
        start.printArray();
        
        System.out.println();
        System.out.println("Linear Search:");
        System.out.println(start.linearSearch(11));
        
        System.out.println();
        System.out.println("Bubble Sort:");
        start.bubbleSort();
        start.printArray();
        
        System.out.println();
        System.out.println("Binary Search:");
        start.binarySearch(11);
        
        System.out.println();
        System.out.println("Selection Sort:");
        start.selectionSort();
        start.printArray();
        
        System.out.println();
        System.out.println("Insertion Sort:");
        start.insertionSort();
        start.printArray();
    }
}