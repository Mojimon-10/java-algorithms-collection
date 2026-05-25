/*
HASH TABLE / HASHMAP: THE O(1) TELEPORTER INSTANT!

A Hash Table is an array-backed data structure designed for maximum 
lookup scale, pairing unique "Keys" to "Values".

HOW IT WORKS AT RUNTIME:
1. THE KEY INPUT:
   You look up data using real-world identifiers (like the word "Pizza")
   instead of guessing numeric array index numbers.

2. THE CALCULATOR (Hash Function):
   The table takes the literal characters of your key, runs a fast 
   mathematical formula, and spits out a fixed array index number.

3. THE INSTANT JUMP:
   The computer skips all loops and scans. It uses that calculated index 
   to jump directly to the memory slot where the value sits.

THE MASTER RULE OF KEYS:
- Keys MUST be 100% unique. 
- If you insert a duplicate key, it will overwrite the old value.
- Values do NOT have to be unique (Multiple keys can point to the same data).


BUT IT HAS "COLLISION" FOR NOW LETS JUST LEARN WHAT IS A HASH TABLE FIRST.

*/

public class basicHashTable
{
    // Under the hood, a Hash Table is just an array
    // We will store string values (like prices or descriptions) in this array.
    private String[] table;
    private int size;

    //Constructor to initialize the array with a fixed size
    public basicHashTable(int capacity) 
    {
        this.size = capacity;
        this.table = new String[capacity];
    }

    // THE HASH FUNCTION (The Math Engine)
    // Takes a literal string word (Key) and converts it into a valid array index.
    private int hashFunction(String key) 
    {
        int hashValue = 0;

        // Loop through each character of the word and add up its numeric character code
        for (int i = 0; i < key.length(); i++) 
        {
            hashValue += key.charAt(i);
        }

        // Use the Modulo (%) operator to ensure the index stays within bounds of our array size.
        // For example: if hashValue is 357 and size is 10, 357 % 10 = 7. Index 7 is returned!
        return hashValue % size;
    }

    // THE PUT METHOD (Storing Data)
    // Pairs the Key to a Value and inserts it directly into the calculated slot.
    public void put(String key, String value) 
    {
        //Calculate the index using our math clerk
        int index = hashFunction(key);
        
        System.out.println("-> Saving Key '" + key + "' at calculated Index: " + index);
        
        //Teleport straight to that index and drop the value
        table[index] = value; 
    }

    // THE GET METHOD (Retrieving Data)
    // Instantly jumps to the calculated index to read the data without loops!
    public String get(String key) 
    {
        //Calculate the exact same index using the same key
        int index = hashFunction(key);
        
        //Jump directly to that index and return what's inside
        return table[index];
    }

    // Helper method to print the physical array look inside memory
    public void printTableDebug() 
    {
        System.out.println("PHYSICAL HASH TABLE ARRAY LOOK");
        
        for (int i = 0; i < size; i++) 
        {
            System.out.println("Index [" + i + "]: " + (table[i] == null ? "[EMPTY]" : table[i]));
        }
        
        System.out.println();
    }

    // Test execution using your "Pizza" example!
    public static void main(String[] args) 
    {
        // Create a basic hash table with 10 slots
        basicHashTable menu = new basicHashTable(10);

        // Put data inside using literal words as keys
        menu.put("Pizza", "₱499.99");
        menu.put("Adobo", "₱150.50");
        menu.put("Borgor", "₱100.00");

        // Take a look at how the array looks under the hood
        menu.printTableDebug();

        // Perform instant lookups! Notice no loop runs to find "Pizza"
        System.out.println("Lookup result for 'Pizza': " + menu.get("Pizza"));
        System.out.println("Lookup result for 'Burger': " + menu.get("Burger"));
    }
}