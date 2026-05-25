/*
THE WORST-CASE RISK (Collisions):
If two totally different keys (like "Pizza" and "Apple") hash to the 
exact same index, a Collision occurs. 

Hash Tables solve this using:
- Chaining: Creating a Linked List inside that specific index slot.
- Open Addressing(Linear Probing): Sliding down to find the next empty available seat.

DOWNSIDE:
chaining can cause O(n) so the O(1) solution just become useless if one index has many values chained together
thats why most use the "java.util.hashmap" to make it stable.

linear probing on the otherhand causes a crash if the fixed array is full.
if you initialized a array[1000] and that 1000 is full it is hard to "extend" an array 

Linear probing is the best solution for a "fixed" data like the provinces of the Philippines
etc. 
Chaining is used for expanding data set or unpredictable dataset.
*/

public class linearProbingHashTable
{
    // Open Addressing requires two parallel arrays: one for keys, one for values
    private String[] keys;
    private String[] values;
    private int size;

    public linearProbingHashTable(int capacity) 
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

    // PUT METHOD: Linear Probing
    public void put(String key, String value) 
    {
        int index = hashFunction(key);
        
        // LINEAR PROBING LOOP: If the slot is occupied, check the next one (index + 1)
        // Wrap around to 0 using the modulo operator (%) if we reach the end of the array
        while (keys[index] != null) 
        {
            // If the key matches, overwrite the value and stop
            if (keys[index].equals(key)) 
            {
                values[index] = value;
                return;
            }
            
            index = (index + 1) % size; // Move to the next available seat
        }

        // Drop the new key and value into the found empty seat
        keys[index] = key;
        values[index] = value;
        System.out.println("-> Saved '" + key + "' at Index [" + index + "]");
    }

    // GET METHOD: Linear Probing
    public String get(String key) 
    {
        int index = hashFunction(key);

        // Scan down the array until we find the key or hit a completely empty slot
        while (keys[index] != null) 
        {
            if (keys[index].equals(key)) 
            {
                return values[index]; // Found it!
            }
            
            index = (index + 1) % size; // Keep sliding down
        }
        return null; // Hit an empty space, meaning the key doesn't exist
    }

    public void printTableDebug() 
    {
        System.out.println("PHYSICAL LINEAR PROBING ARRAY LOOK: ");
        for (int i = 0; i < size; i++) {
            System.out.println("Index [" + i + "]: " + (keys[i] == null ? "[EMPTY]" : "(" + keys[i] + ": " + values[i] + ")"));
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        // Size 3 to guarantee collisions
        linearProbingHashTable menu = new linearProbingHashTable(3);
        
        System.out.println("LINEAR PROBING INSERTIONS");
        menu.put("Pizza", "10.99");  // Hashes to 1
        menu.put("Burger", "6.50");   // Hashes to 0
        menu.put("Salad", "5.00");    // Hashes to 0 -> Collides! Slides to 2
        
        menu.printTableDebug();
        System.out.println("Lookup 'Salad': " + menu.get("Salad"));
    }
}