/* So linked list is like a pointer on which is next in the chain
so instead of array which is like in a box where you have to move the entire row if you want to
insert data inbetween them, linked list just modify their pointer on which to go next.
  Cut in:  [Node A] ----X--> [Node B] --> null 
                  \            ^
                  \-> [Node X]/
                  
    This represents a single "Leaf" in the chain. */
    class Node 
    {
        int data;  //holds the actual value
        Node next; //holds the arrow pointing to the next leaf
    
        //constructor to make a new leaf
        public Node(int data) 
        {
            this.data = data;
            this.next = null; //new leaves dont point to anything yet
        }
    }
    
    class SimpleLinkedList 
    {
        Node head = null; //the absolute start of the chain.

        // CASE 1: ADD AT THE END ===
        public void add(int data) 
        {
            Node newLeaf = new Node(data);
    
            // If the branch is empty, this new leaf is the head!
            if (head == null) 
            {
                head = newLeaf;
                return;
            }
    
            // Otherwise cycle to the very end of the line
            Node current = head;
            while (current.next != null) 
            {
                current = current.next; // follow the arrow forward
            }
    
            // Change the last leaf's arrow from null to our new leaf
            current.next = newLeaf;
        }
        
        // CASE 2: INSERT IN BETWEEN (AFTER A SPECIFIC VALUE/INBEETWEEN)
        public void insertAfter(int target, int newData) 
        {
            Node current = head;
        
            // first is to cycle through the list to find the node containing our 'target' (Node A)
            while (current != null) 
            {
                if (current.data == target) 
                {
                    // found Node A! 
                    // then we create our brand new leaf (Node X)
                    Node newLeaf = new Node(newData);
        
                    // connect the new leaf's arrow forward to Node A's next neighbor
                    // so like for example 10 --> 30 --->null 
                    // we added 20 inbetween 10 and 30 so therefore
                    // the new leaf will inherit the arrow of 10 and 20 will now point towards 30
                    newLeaf.next = current.next;
        
                    // change Node A's arrow to point directly to our new leaf
                    current.next = newLeaf;
                    
                    System.out.println("Inserted " + newData + " right after " + target);
                    return; // Mission accomplished!
                }
                current = current.next; // Move to the next leaf
            }
        
            //if the loop finished it means we couldnt find the target value
            System.out.println("Target value " + target + " not found in the list.");
        }
    

        // CASE 3: DELETE A VALUE (BYPASS TRICK)
        public void delete(int target) 
        {
            if (head == null) return; // Can't delete from an empty list
    
            // Case A: The item to delete is right at the HEAD
            if (head.data == target) 
            {
                head = head.next; //move the head forward. Old head is now cut off
                return;
            }
    
            // Case B: The item is somewhere in the middle or end
            Node current = head;
    
            // Look ONE STEP AHEAD using current.next so we don't pass it
            while (current.next != null) 
            {
                if (current.next.data == target) 
                {
                    // we found it We tell 'current' to snap its arrow 
                    // and point straight to the target's next neighbor.
                    current.next = current.next.next; 
                    return; // Mission complete, exit the method
                }
                current = current.next; // Keep walking forward
            }
        }
        
        // CYCLE THROUGH (PRINT)
        public void printList() 
        {
            if (head == null) 
            {
                System.out.println("The list is empty.");
                return;
            }
    
            Node current = head; // start at the beginning
            System.out.print("Current Chain: ");
            
            // loop runs until current walks off the edge of the list into null
            while (current != null) 
            {
                System.out.print("[" + current.data + "] -> ");
                current = current.next; //move to the next leaf
            }
            System.out.println("NULL");
        }
    }
    
    

public class linkedList
{
	public static void main(String[] args) 
	{
	    
	    SimpleLinkedList list = new SimpleLinkedList();
	    
	    System.out.println("Adding Data:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.printList(); // Output: [10] -> [20] -> [30] -> [40] -> NULL

        System.out.println();
        System.out.println("Deleting from the Middle (30): ");
        list.delete(30); // 20 will snap its arrow directly to 40, skipping 30
        list.printList(); // Output: [10] -> [20] -> [40] -> NULL

        System.out.println();
        System.out.println("Deleting the Head (10): ");
        list.delete(10); // The head pointer just shifts to 20
        list.printList(); // Output: [20] -> [40] -> NULL
        
        System.out.println();
        System.out.println("Inserting from the Middle (30):");
        list.insertAfter(20, 30);
        list.printList();
	}
}

