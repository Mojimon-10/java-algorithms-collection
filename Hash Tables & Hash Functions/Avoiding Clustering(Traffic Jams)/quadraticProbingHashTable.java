/*
to avoid clustering instead of linear Probing
where you are checking each index to the if it is empty or not 
and it becomes O(n)

we used quadratic to jumpusing squares (1^2, 2^2, 3^2, 4^2...)  
it jumps +1 then +4 then +9 then +16
*/

public class quadraticProbingHashTable 
{

    private String[] keys;
    private String[] values;
    private int size;

    public quadraticProbingHashTable(int capacity) 
    {
        this.size = capacity;
        this.keys = new String[capacity];
        this.values = new String[capacity];
    }

    private int hashFunction(String key) 
    {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) 
        
        {
            hashValue += key.charAt(i);
        }
        
        return Math.abs(hashValue) % size;
    }

    // PUT METHOD: Quadratic Probing
    public void put(String key, String value) 
    {
        int initialIndex = hashFunction(key);
        int currentIndex = initialIndex;
        int counter = 1; // Tracks our jump sequence (1, 2, 3...)

        // Loop runs as long as the current seat is occupied
        while (keys[currentIndex] != null) 
        {
            // Overwrite check (standard rule)
            if (keys[currentIndex].equals(key)) 
            {
                values[currentIndex] = value;
                return;
            }

            // CRITICAL STEP: Calculate the next quadratic leap!
            // Formula: (Initial Hash Position + counter^2) % Array Size
            currentIndex = (initialIndex + (counter * counter)) % size;
            
            System.out.println("Collision for '" + key + "'! Leaping quadratically to Index [" + currentIndex + "]");
            counter++;
        }

        // We broke out of the loop, meaning 'currentIndex' is now an empty seat!
        keys[currentIndex] = key;
        values[currentIndex] = value;
        System.out.println("-> Saved '" + key + "' successfully at Index [" + currentIndex + "]\n");
    }

    // GET METHOD: Quadratic Probing
    public String get(String key) 
    {
        int initialIndex = hashFunction(key);
        int currentIndex = initialIndex;
        int counter = 1;

        while (keys[currentIndex] != null) 
        {
            if (keys[currentIndex].equals(key)) 
            {
                return values[currentIndex]; // Found it!
            }
            
            currentIndex = (initialIndex + (counter * counter)) % size;
            counter++;
        }
        return null; // Hit an empty slot, key doesn't exist
    }

    public void printTableDebug() 
    {
        System.out.println("--- PHYSICAL QUADRATIC PROBING ARRAY LOOK ---");
        for (int i = 0; i < size; i++) 
        {
            System.out.println("Index [" + i + "]: " + (keys[i] == null ? "[EMPTY]" : "(" + keys[i] + ": " + values[i] + ")"));
        }
        
        System.out.println("---------------------------------------------\n");
    }

    public static void main(String[] args) 
    {
        // We pick 7 (a prime number!) to maximize our coverage
        quadraticProbingHashTable menu = new quadraticProbingHashTable(7);

        System.out.println("=== STARTING INSERTIONS ===");
        menu.put("Pizza", "10.99");  // Let's assume this takes Index 2
        menu.put("Burger", "6.50");   // Let's assume this also hits Index 2 -> Collision 1
        menu.put("Salad", "5.00");    // Let's assume this also hits Index 2 -> Collision 2

        menu.printTableDebug();
        
        System.out.println("Lookup 'Salad': " + menu.get("Salad"));
    }
}