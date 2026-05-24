//doubleEndedlinked list is an upgraded version of just a regular linked list.
// in doubleendedlinked list it now has a tail!
// so basically 1 2 3 4
//              ^head  ^tail
// if i want to add a value at the end of the list them boom ignore 1 2 3 and straight to tail
// no always starting at the head

class Node 
{
    int data;
    Node next;

    public Node(int data) 
    {
        this.data = data;
        this.next = null;
    }
}

class doubleEndedList 
{
    // We now have TWO main pointers tracking the ends of our list
    Node head = null;
    Node tail = null;

    // NEW & IMPROVED: ADD AT END (No more while loop!) 
    public void addLast(int data) 
    {
        Node newLeaf = new Node(data);

        // If empty, this new leaf is BOTH the head and the tail
        if (head == null) 
        {
            head = newLeaf;
            tail = newLeaf;
            return;
        }

        // Instead of a loop, we use our shortcut!
        tail.next = newLeaf; // Tell the current last node to point to our new node
        tail = newLeaf;      // Update our tail bookmark to be the new node
    }

    // ADD AT FRONT
    public void addFirst(int data) 
    {
        Node newLeaf = new Node(data);

        if (head == null) 
        {
            head = newLeaf;
            tail = newLeaf;
            return;
        }

        newLeaf.next = head; // Point new node to old head
        head = newLeaf;      // Shift head bookmark to new node
    }

    public void printList() 
    {
        Node current = head;
        System.out.print("Double-Ended Chain: ");
        while (current != null) 
        {
            System.out.print("[" + current.data + "] -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
    
}

public class doubleEndedLinkedList 
{
    public static void main(String[] args) 
    {
        doubleEndedList doubleList = new doubleEndedList();
        
        System.out.println();
        System.out.println("Add at the Front: ");
        doubleList.addFirst(10);
        doubleList.addFirst(11);
        doubleList.printList();
        
        System.out.println();
        System.out.println("Add at the Back: ");
        doubleList.addLast(12);
        doubleList.addLast(14);
        doubleList.addLast(13);
        doubleList.printList();
        

    }
}