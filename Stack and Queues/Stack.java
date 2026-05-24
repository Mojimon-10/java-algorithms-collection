import java.util.Stack;

class Stack
{
    public static void Stack(String[] args) 
    {
        // create the new stack. using the java.util.stack
        Stack<Integer> stackA = new Stack<>();
        
        // stack is a LIFO meaning that you can only access the very top of the stack like the game "tower of hanoi"
        // so for example i want to access the very bottom of the stack
        
        // push items onto Stack A (4 goes in first, so it's at the bottom)
        stackA.push(4); // bottom
        stackA.push(3);
        stackA.push(2);
        stackA.push(1); // top
        
        System.out.println("Original Stack A: " + stackA); 
        // displays [4, 3, 2, 1]
        
        // create our temporary stack (Stack B)
        // remember its like "tower of hanoi" once the value you pop or remove at the stack we cannot access that if we do not place it on other stack.
        Stack<Integer> stackB = new Stack<>();
        
        // move the top 3 items (1, 2, 3) from Stack A to Stack B
        // we leave exactly 1 item behind (the bottom item, 4)
        // this code is doing a while loop so while the stack is 4 since we push 4 values it will keep looping until only 1 value remain which is the very bottom
        while (stackA.size() > 1) 
        {
            int poppedItem = stackA.pop();
            stackB.push(poppedItem); // so that the popped item does not get deleted we need to move the value to the other stack
        }
        
        // access the bottom element (4) safely using peek()
        int bottomItem = stackA.peek();
        System.out.println("The bottom item is: " + bottomItem);
        System.out.println();
        
        // just to show what they look like right now:
        System.out.println("Stack A right now: " + stackA); 
        // contains just [4]
        
        System.out.println("Stack B right now: " + stackB); 
        // contains [1, 2, 3] (3 is at the top ; 1 is the bottom)
        
        // put everything back into Stack A in the correct order
        while (!stackB.isEmpty()) 
        {
            stackA.push(stackB.pop());
        }
        
        // verify Stack A is perfectly restored
        System.out.println("Restored Stack A: " + stackA); 
        // displays [4, 3, 2, 1]
    }
}