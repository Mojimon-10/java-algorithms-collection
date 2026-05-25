/*
to avoid clustering 
we use double hashing
so the difference is that double hashing calculate the stride value
so instead of jumping it calculates the word instead into a ASCII code 
since every word cannot be the same it will ALWAYS have a deterministic value
not random jumps

*/

public class doubleHashingHashTable 
{

    private String[] keys;
    private String[] values;
    private int size;

    // Constructor (Size MUST be a prime number for the math to work safely!)
    public doubleHashingHashTable(int capacity) 
    {
        this.size = capacity;
        this.keys = new String[capacity];
        this.values = new String[capacity];
    }

    // Hash Function 1: Determines the STARTING location
    private int hashFunction1(String key) 
    {
        int hash = 0;
        
        for (int i = 0; i < key.length(); i++) 
        {
            hash += key.charAt(i);
        }
        return Math.abs(hash) % size;
    }

    // Hash Function 2: Determines the JUMP STEP SIZE
    // CRITICAL: Must never return 0, otherwise the jump distance would be 0 and cause an infinite loop!
    private int hashFunction2(String key) 
    {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) 
        {
            hash += key.charAt(i) * 31; // Slightly different math multiplier
        }
        
        // Use a smaller prime (like 5) and subtract from it.
        // This guarantees a non-zero jump interval between 1 and 5.
        return 5 - (Math.abs(hash) % 5);
    }

    // PUT METHOD: Double Hashing
    public void put(String key, String value)
    {
        int initialIndex = hashFunction1(key);
        int currentIndex = initialIndex;
        
        // Calculate the permanent, custom jump interval for THIS SPECIFIC KEY
        int stepSize = hashFunction2(key); 
        int attempt = 1;

        System.out.println("-> '" + key + "' wants to start at Index [" + initialIndex + "]. Custom Step Size is: " + stepSize);

        // Keep jumping until we find an empty slot
        while (keys[currentIndex] != null)
        {
            if (keys[currentIndex].equals(key)) 
            {
                values[currentIndex] = value; // Overwrite
                return;
            }

            // Move forward by our custom step size!
            currentIndex = (initialIndex + (attempt * stepSize)) % size;
            System.out.println("Collision! Jumping by " + stepSize + " to Index [" + currentIndex + "]");
            attempt++;
        }

        // Drop it into the customized open seat
        keys[currentIndex] = key;
        values[currentIndex] = value;
        System.out.println("Saved successfully at Index [" + currentIndex + "]\n");
    }

    public void printTableDebug() 
    {
        System.out.println("--- PHYSICAL DOUBLE HASHING ARRAY LOOK ---");
        for (int i = 0; i < size; i++) 
        {
            System.out.println("Index [" + i + "]: " + (keys[i] == null ? "[EMPTY]" : "(" + keys[i] + ": " + values[i] + ")"));
        }
        
        System.out.println("------------------------------------------\n");
    }

    public static void main(String[] args) 
    {
        doubleHashingHashTable menu = new doubleHashingHashTable(7);

        // Let's force two words to collide at the same index
        menu.put("Pizza", "10.99");
        menu.put("Burger", "6.50"); 
        menu.put("Salad", "5.00");  

        menu.printTableDebug();
    }
}