class javaAlgo
    {
        // declare as private so within the class.
        // int[] <- means array 'Array' <-- means the array name.
        // new int <- new interger ; [50] <- means the boxes of empty array;
        private int[] Array = new int[50];
        // int arraysize = 10 <- means that we will fill in ONLY 10/50 of the array.
        private int arraySize = 10;
        
        public void generateArray()
        {
            // i = 0 as starting then every i < arraysize it will keep incrementing and doing the method inside this for loop until the arraysize < i.
        for(int i = 0; i < arraySize; i++)
        {
            // we will fill the array with random number so
            // int means integer no float numbers so if 10.14 it will be 10.
            // math random is 0.00-0.99 so if no *10 it will be 0 every time so we need *10 in order to be 0.99-9.99 and the +10 to be 11-19
            Array[i] = (int)(Math.random()*10)+10;
        }
            // then a method forprint
            // again for loop so the index will start at 0; so every i is less than array size it will increment then will do the function inside this for loop.
            for(int i = 0; i < arraySize; i++)
            {
                //print the index so each 'boxes' has a number 0-49 since we declared 50 array
                System.out.println(i);
                // we print the array data so the data itself.
                System.out.println(Array[i]);
            }
        }
		
        // we used public 'int' because in order to use this we only have to return a integer it will always return a value to the main method so it is not a black hole like public void.
        public int getValueatIndex(int index) // integer and we have to get the index
        {
            // so if index (it is the value that we will put in the main method) is less than array size then it will access the array and get the value of that index. else zero
            if(index < arraySize) return Array[index];
            return 0;
        }
        
        public void deleteArray(int index)
        {
            // this will only execute if the value is less than the arraysize
            if(index >= 0 && index < arraySize)
            {
                // so we used for loop we declared i = index because the value index is what we will need to delete
                // so if i < arraysize- 1 like if 8 < 10-1 = 9 so the for loop will execute but if 9 < 9 then it will not execute because the value after 10 HAS NO VALUE TO REPLACE. SO WE NEED TO DELETE UP UNTIL INDEX 9 ONLY CUZ IF WE DELETE 10 THEN WHAT VALUE WILL REPLACE 10?
                for(int i = index; i < (arraySize - 1); i++)
                {
                    // array index that i want to be deleted will be replace by the number below it.
                    Array[i] = Array[i + 1];
                }
            
            // we of course decrease the array size because we deleted a value so if we delete 1 value the arraysize will be 9 in order for it to work again not just once.
                arraySize--
            }
        }
        
        public void insertArray(int Value)
        {
            // so inorder to not overflow out array which is only declared max 50.
            if(arraySize < 50)
            {
                //Array[arraySize so if the array size is 9 the value will go to index 9]
                Array[arraySize] = value;
                // increment the arraysize because the empty array has now a value therefore we increase the size.
                arraySize++;
            }
            
            return 0;

        }
        
        public boolean doesArrayExist(int searchValue)
        {
            boolean ArrayExist = false;
            
            for(int i = 0; i < arraySize; i++)
            {
                if(Array[i] == searchValue)
                {
                    ArrayExist = true;
                }
            }
            return ArrayExist;
        }
  
    }
        public static void main(String[] args) 
        {
            // since the code above is non-static, we only have the blueprint (the Class) and haven't built it.
            // so inside the main method, we build a real object out of our 'Main' class and name it 'demo'.
             Main demo = new Main();
			 
             /// now we use our object 'demo' to call/activate the 'generateArray' method so it runs.
             // so like we built the "house" by using the main class and we named it demo. so the demo."build the furnitures".
             demo.generateArray();
			 
             // we need system print since no print at this method.
             System.out.println(demo.getValueatIndex(3)); //<- the 3 is the value that we want to access.
             
             System.out.println(demo.doesArrayExist(11)); 
             
             demo.generateArray();
             
        }
    }