/* Now we have the final form of linked list
remember that linked list can only move forward? 
basically doubly linked list can move backwards
while retaining its shortcut of head and its tail

NULL <-> A <-> B <-> C <-> NULL
head        tail

*/

class DoublyNode 
{
    int data;
    DoublyNode next;
    DoublyNode prev; // The backward arrow

    public DoublyNode(int data) 
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class FullDoublyLinkedList 
{
    DoublyNode head = null;
    DoublyNode tail = null;

    // add to the very end of the two-way highway
    public void addLast(int data) 
    {
        DoublyNode newNode = new DoublyNode(data);

        //if the list is empty, same as before
        if (head == null) 
        {
            head = newNode;
            tail = newNode;
            return;
        }

        //connect the final two-way handshake
        tail.next = newNode; // 1. Old tail points FORWARD to the new node
        newNode.prev = tail; // 2. New node points BACKWARD to the old tail
        tail = newNode;      // 3. Move the tail bookmark to the new node
    }
    
    public void printList() 
    {
        if (head == null) 
        {
            System.out.println("NULL");
            return;
        }
    
        DoublyNode current = head;
        //print the starting NULL and the backward arrow for the head
        System.out.print("NULL <- ");
        
        while (current != null) {
            System.out.print("[" + current.data + "]");
            
            //if there is a next node, print a two-way arrow (<->)
            if (current.next != null) 
            {
                System.out.print(" <-> ");
            } else 
            {
                //if we are at the very last node, print the ending arrow
                System.out.print(" -> ");
            }
            
            current = current.next; //move forward
        }
        
        // 4. Print the final NULL at the end
        System.out.println("NULL");
    }
}
public class doublyLinkedList 
{
    public static void main(String[] args) 
    {
        FullDoublyLinkedList list = new FullDoublyLinkedList ();
        
        System.out.println();
        System.out.println("Adding Data: ");
        list.addLast(10);
        list.addLast(18);
        list.addLast(11);
        list.addLast(14);
        list.addLast(15);
        list.printList();

    }
}