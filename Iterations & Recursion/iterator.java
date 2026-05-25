import java.util.LinkedList;
import java.util.Iterator; 

/* so we now know the linkedlist and its variations.
iterator acts a bookmark, where it remembers where it stands.

we must differentiate iterator vs iteration
Iteration is the process of repeating through a loop (like for or while).
An iterator is the tool/object that keeps track of the current position while traversing items, like a bookmark so you don’t get lost.

A linked list is scattered to find an item you have to count the links from the head.
if you try to use a standard index loop (list.get(i)) on a linked list, 
the computer gets amnesia:
   - To get index 0: Starts at Head -> Finds A
   - To get index 1: Forgets where it was Goes back to Head -> A -> Finds B
   - To get index 2: Forgets again! Goes back to Head -> A -> B -> Finds C
This is why a standard index loop destroys your performance on a linked list.


but with iterator  it is a bookmark built primarily to save the Linked List from its own amnesia.
it stands on a node, hands you the value, and stays right there.
when you say next(), it doesn't go back to the head it just slides to the next link.
   - Starts at Head -> Hands you A (Bookmark stays at A)
   - Directly from A -> Hands you B (Bookmark stays at B)
   - Directly from B -> Hands you C (Bookmark stays at C) 
   
Linked Lists DESPERATELY need iterators so they don't have to run back to the head 
every single time you want the next item in line.

*/
public class iterator
{
    public static void main(String[] args) 
    {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        // THE EXPLICIT ITERATOR WAY
        // Step 1: Create the iterator. 
        // Right now, the bookmark is sitting JUST BEFORE the first element.
        // Position:   (it) -> [10] -> [20] -> [30] -> NULL
        Iterator<Integer> it = list.iterator();

        // Step 2: The while loop asks hasNext()
        // Loop 1: Looks ahead. Sees [10]. Returns true!
        // Loop 2: Looks ahead. Sees [20]. Returns true!
        // Loop 3: Looks ahead. Sees [30]. Returns true!
        // Loop 4: Looks ahead. Sees NULL. Returns false! -> Loop Ends.
        while (it.hasNext()) 
        {
            // Step 3: it.next() does a double-action:
            // 1. It jumps OVER the next node.
            // 2. It grabs that node's data and assigns it to 'value'.
            Integer value = it.next(); 
            
            // Visual of the bookmark moving smoothly without ever running back to head:
            // After 1st next():  [10] -> (it) -> [20] -> [30] -> NULL  (value = 10)
            // After 2nd next():  [10] -> [20] -> (it) -> [30] -> NULL  (value = 20)
            // After 3rd next():  [10] -> [20] -> [30] -> (it) -> NULL  (value = 30)

            System.out.println("Found value: " + value);
        }
    }
}