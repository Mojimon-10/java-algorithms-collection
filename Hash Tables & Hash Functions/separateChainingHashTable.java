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

public class separateChainingHashTable 
{

    // The Linked List Node structure
    private static class Node 
    {
        String key;
        String value;
        Node next;

        public Node(String key, String value) 
        {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] table;
    private int size;

    public separateChainingHashTable(int capacity) 
    {
        this.size = capacity;
        this.table = new Node[capacity];
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

    // PUT METHOD: Separate Chaining
    public void put(String key, String value) 
    {
        int index = hashFunction(key);
        Node current = table[index];

        // Check the chain for duplicates to perform an overwrite
        while (current != null) {
            if (current.key.equals(key)) 
            {
                current.value = value;
                return;
            }
            
            current = current.next;
        }

        // No duplicate found. Create a new Node and add it to the FRONT of the chain
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        System.out.println("-> Saved '" + key + "' inside Chain Bucket [" + index + "]");
    }

    //  GET METHOD: Separate Chaining
    public String get(String key) 
    {
        int index = hashFunction(key);
        Node current = table[index];

        // Search only inside this single bucket's chain link by link
        while (current != null) 
        {
            if (current.key.equals(key)) 
            {
                return current.value;
            }
            
            current = current.next;
        }
        
        return null;
    }

    public void printTableDebug() 
    {
        System.out.println("PHYSICAL SEPARATE CHAINING LOOK");
        for (int i = 0; i < size; i++) 
        {
            System.out.print("Index [" + i + "]: ");
            Node current = table[i];
            
            if (current == null) 
            {
                System.out.println("[EMPTY]");
            } 
            
            else 
            {
                while (current != null) 
                {
                    System.out.print("(" + current.key + ": " + current.value + ") ──> ");
                    current = current.next;
                }
                
                System.out.println("null");
            }
        }
        
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) 
    {
        // Size 2 to guarantee collisions
        separateChainingHashTable menu = new separateChainingHashTable(2);
        
        System.out.println("=== SEPARATE CHAINING INSERTIONS ===");
        menu.put("Pizza", "10.99");  // Hashes to 1
        menu.put("Burger", "6.50");   // Hashes to 0
        menu.put("Salad", "5.00");    // Hashes to 0 -> Collides! Chains to front of Index 0
        
        menu.printTableDebug();
        System.out.println("Lookup 'Salad': " + menu.get("Salad"));
    }
}
