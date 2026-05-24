class Queue
{
    private int[] array;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    
    // so queue is what the names is queue in line
    // so if stack is lifo(last in; first out)
    // then queue is fifo(first in; first out)
    // queue is like a line when you order somethings you fall in line
    
    // constructor to initialize the queue
    public Queue(int size) 
    {
        array = new int[size]; // whatever size the user wants
        capacity = size; // the capcity of the queue is what the user input
        front = 0; // the first in line it will be index 0 remember we used arrays.
        rear = -1; // the last in line ; we need to declare -1 because the line has NOT existed yet.
        count = 0; // this is the head count the actual data falling in line.
    }

    // ENQUEUE (add an item to the back of the line)
    public void enqueue(int item) 
    {
        if (count == capacity) // count is zero here and the capacity is the user input; so if the capcity is 100 that can fall in line and the count has beconme 100 it cannot accept anymore data.
        {
            System.out.println("Queue is Full! Cannot add " + item);
            return;
        }
        
        // move the rear pointer up and insert the item
        rear = rear + 1; // the line has started
        array[rear] = item; //array[rear] <-- the rear becomes zero so the line has started and the data is whatever the item is.
        count++; //headcount has started this now becomes +1
        System.out.println("Enqueued: " + item);
    }

    // DEQUEUE (emove and return the item at the front of the line)
    public int dequeue() 
    {
        if (count == 0) 
        {
            System.out.println("Queue is Empty! Nothing to dequeue.");
            return -1;
        }
        
        // grab the front item
        int frontItem = array[front]; //front is always gonna be index 0 is the array since first in line first out
        
        // shift the front pointer up to the next item
        // so the front becomes the index 1 not the index zero
        // |0||1| <-- the array so this will become | | |1| the index 0 is now empty but only the pointer will move not the whole data.
        front = front + 1;
        count--;
        return frontItem;
    }

    // PEEK (just look at the front item without removing it)
    public int peek() 
    {
        if (count == 0) 
        {
            System.out.println("Queue is Empty!");
            return -1;
        }
        return array[front];
    }

    public static void main(String[] args) 
    {
        // create a queue that can hold up to 5 items
        Main start = new Main();
        start.Queue(5);

        System.out.println("Enqueuing Items (Joining the Line)");
        start.enqueue(10); // Joins first (Front)
        start.enqueue(20);
        start.enqueue(30); // Joins last (Back)

        System.out.println();
        System.out.println("Checking the Front");
        System.out.println("Next in line (peek): " + start.peek()); // Should be 10

        System.out.println();
        System.out.println("Dequeuing Items (Serving the Line)");
        System.out.println("Served: " + start.dequeue()); // removes and returns 10
        System.out.println("Served: " + start.dequeue()); // removes and returns 20

        System.out.println();
        System.out.println("Final Check");
        System.out.println("Who is left at the front? " + start.peek()); // Should be 30
    }
}