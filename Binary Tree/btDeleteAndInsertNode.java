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

public class btDeleteAndInsertNode 
{
    
    Node root;

    public btDeleteAndInsertNode() 
    {
        this.root = null;
    }

    // 1. INSERTION ENGINE
    public void insert(int value) 
    {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) 
    {
        // If we find an empty spot, drop the new node here
        if (current == null) 
        {
            return new Node(value);
        }

        // Otherwise, navigate the tree based on values
        if (value < current.data) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.data) {
            current.right = insertRecursive(current.right, value);
        }
        
        return current;
    }

    // 2. DELETION ENGINE
    public void delete(int value) 
    {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) 
    {
        // Base Case: The value doesn't exist in the tree
        if (current == null) 
        {
            return null;
        }

        // STEP A: Hunt down the node we want to delete
        if (value < current.data) 
        {
            current.left = deleteRecursive(current.left, value);
        } 
        
        else if (value > current.data) 
        {
            current.right = deleteRecursive(current.right, value);
        } 
        
        // STEP B: We found it! (value == current.data). Time to delete.
        else 
        {
            // SCENARIO 1 & 2: Node has 0 children or only 1 child
            if (current.left == null) 
            {
                return current.right; // If left is empty, promote the right child
            } 
            
            else if (current.right == null) 
            {
                return current.left;  // If right is empty, promote the left child
            }

            // SCENARIO 3: Node has 2 children
            // Find the In-Order Successor (smallest value in the right branch)
            current.data = findMinValue(current.right);

            // Delete that duplicate successor value from the right branch
            current.right = deleteRecursive(current.right, current.data);
        }

        return current;
    }

    // Helper method to find the leftmost (smallest) leaf in a branch
    private int findMinValue(Node node) 
    {
        int minValue = node.data;
        while (node.left != null) 
        {
            minValue = node.left.data;
            node = node.left;
        }
        
        return minValue;
    }

    // UTILITY: In-Order Print to verify our results
    public void printInOrder() 
    {
        inOrderWorker(root);
        System.out.println();
    }

    private void inOrderWorker(Node node) 
    {
        if (node != null) 
        {
            inOrderWorker(node.left);
            System.out.print(node.data + " ");
            inOrderWorker(node.right);
        }
    }

    // EXECUTION
    public static void main(String[] args) 
    {
        btDeleteAndInsertNode tree = new btDeleteAndInsertNode();

        // 1. Test Insertion
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Initial Tree (Sorted In-Order): ");
        tree.printInOrder(); // Expected: 20 30 40 50 60 70 80

        // 2. Test Deletion Scenario 1: Delete a leaf node (20)
        System.out.println("\n--- Deleting 20 (Leaf Node) ---");
        tree.delete(20);
        System.out.print("Tree after deleting 20: ");
        tree.printInOrder(); // Expected: 30 40 50 60 70 80

        // 3. Test Deletion Scenario 2: Delete a node with 1 child (30 now only has 40)
        System.out.println("\n--- Deleting 30 (Node with 1 child) ---");
        tree.delete(30);
        System.out.print("Tree after deleting 30: ");
        tree.printInOrder(); // Expected: 40 50 60 70 80

        // 4. Test Deletion Scenario 3: Delete the Root node with 2 children (50)
        System.out.println("\n--- Deleting 50 (Root Node with 2 children) ---");
        tree.delete(50); 
        // 60 is the smallest value in 50's right branch, so 60 becomes the new root!
        System.out.print("Tree after deleting 50: ");
        tree.printInOrder(); // Expected: 40 60 70 80
    }
}