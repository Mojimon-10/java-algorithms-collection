/* Binary search tree 

A Binary Search Tree gives us the dynamic speed of a Linked List combined with the high-speed searching power of a sorted Array.

has 3 variations
pre order TRAVERSAL
in order TRAVERSAL
post order TRAVERSAL

pre order traversal goes from ROOT LEFT RIGHT
in order traversal goes from LEFT ROOT RIGHT
post order traversal goes from LEFT RIGHT ROOT

IT NEVER GOES RIGHT FIRST!
ALWAYS ROOT TO  LEFT OR LEFT ITSELF

*/

class Node 
{
    int data;
    Node left;
    Node right;

    public Node(int value) 
    {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class binarySearchTree
{
    
    Node root;

    public binarySearchTree() 
    {
        this.root = null;
    }

    // 1. PRE-ORDER TRAVERSAL (Root -> Left -> Right)
    public void printPreOrder() 
    {
        System.out.print("Pre-Order  (Root -> Left -> Right): ");
        preOrderWorker(root);
        System.out.println();
    }

    private void preOrderWorker(Node current) 
    {
        if (current == null) return; // Base Case: Hit a dead end, turn around

        System.out.print(current.data + " "); // STEP 1: Print the ROOT first!
        preOrderWorker(current.left);          // STEP 2: Drill down the Left branch
        preOrderWorker(current.right);         // STEP 3: Drill down the Right branch
    }

    // 2. IN-ORDER TRAVERSAL (Left -> Root -> Right)
    public void printInOrder() 
    {
        System.out.print("In-Order   (Left -> Root -> Right): ");
        inOrderWorker(root);
        System.out.println();
    }

    private void inOrderWorker(Node current) 
    {
        if (current == null) return; // Base Case: Hit a dead end, turn around

        inOrderWorker(current.left);           // STEP 1: Go Left as far as possible first
        System.out.print(current.data + " "); // STEP 2: Print the ROOT in the middle!
        inOrderWorker(current.right);          // STEP 3: Go Right
    }

    // 3. POST-ORDER TRAVERSAL (Left -> Right -> Root)
    public void printPostOrder() 
    {
        System.out.print("Post-Order (Left -> Right -> Root): ");
        postOrderWorker(root);
        System.out.println();
    }

    private void postOrderWorker(Node current) 
    {
        if (current == null) return; // Base Case: Hit a dead end, turn around

        postOrderWorker(current.left);          // STEP 1: Clear out the entire Left branch
        postOrderWorker(current.right);         // STEP 2: Clear out the entire Right branch
        System.out.print(current.data + " ");  // STEP 3: Print the ROOT at the very end!
    }

    // STANDARD INSERTION (To build our structural test tree)
    public void insert(int value) 
    {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) 
    {
        if (current == null) return new Node(value);
        
        if (value < current.data) 
        {
            current.left = insertRecursive(current.left, value);
        } 
        
        else if (value > current.data) 
        {
            current.right = insertRecursive(current.right, value);
        }
        
        return current;
    }

    // EXECUTION
    public static void main(String[] args) 
    {
        binarySearchTree tree = new binarySearchTree();

        // Let's seed the tree with our classic values
        tree.insert(10); // Root
        tree.insert(5);  // Left child
        tree.insert(20); // Right child
        tree.insert(2);  // Left-Left child
        tree.insert(7);  // Left-Right child

        System.out.println("=== RUNNING ALL TRAVERSALS ON THE SAME TREE ===");
        tree.printPreOrder();  // Expected: 10 5 2 7 20
        tree.printInOrder();   // Expected: 2 5 7 10 20
        tree.printPostOrder(); // Expected: 2 7 5 20 10
        System.out.println("===============================================");
    }
}