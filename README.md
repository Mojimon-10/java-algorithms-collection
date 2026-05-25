# Java Algorithms

A clean, step-by-step implementation of fundamental computer science algorithms in Java. This project serves as a practical guide for mastering array manipulation, searching, and sorting logic.

## Repository Structure (LEARN THIS IN ORDER!)

### 1. Java Algorithms (Array Operations)
* **Array Setup** - Core array initialization.
* **Insert** - Adding elements to specific positions.
* **Delete** - Removing elements and handling shifting.
* **Search** - Finding elements within standard arrays.

### 2. Search Algorithms
* **Linear Search** - Sequential scanning for unordered data.
* **Binary Search** - Fast, divide-and-conquer search for sorted data.

### 3. Sorting Algorithms
* **Bubble Sort** - Repeatedly swapping adjacent elements.
* **Selection Sort** - Finding the minimum element and moving it to the front.
* **Insertion Sort** - Building a sorted array one element at a time.

### 4. Stacks & Queues
* **Stacks** - A vertical "Last-In, First-Out" (LIFO) data structure where items are added (push) and removed (pop) only from the top. Think of a stack of dinner plates—the last plate you put on top is always the first one you take off. Crucial for backtracking systems and tracking function calls in memory.
* **Queues** - A horizontal "First-In, First-Out" (FIFO) data structure where items join at the back (enqueue) and leave from the front (dequeue). Just like a real-world checkout line—the first person to get in line is the first one served. Essential for print jobs, background tasks, and handling requests in order.

### 5. Linked List 
* **Linked List** - One-way node chain using forward indicators (next). Includes traversing, middle deletion, and inserting in between via pointer manipulation.
* **Double-Ended Linked List** - One-way node chain optimized with a tail pointer shortcut. Ideal foundation for high-performance Queues.
* **Doubly Linked List** - Two-way node highway utilizing both next and prev arrows. Allows bidirectional traversal and independent node deletion.

### 6. Iteration & Recursion
* **Iteration(Loops) / Iterator(Bookmark)** - Using for, while, and do-while control structures to repeat tasks sequentially with a fixed memory footprint.
* **Recursion (Self-Calls)** - The process where a method solves a problem by calling a smaller version of itself. Focuses on tracking the Base Case (the exit condition to prevent a stack overflow error) and the Recursive Case (stacking the execution frames).

### 7. Advanced Sorting Algorithms
* **Merge Sort** - A highly predictable, stable algorithm using recursive Divide and Conquer. It chops the array down to single elements and beautifully zips them back up into new, sorted temporary arrays.
* **Shell Sort** - An optimized variation of Insertion Sort that compares elements using jumping intervals (or gaps). It allows out-of-place numbers to "teleport" massive distances across the array before running a lightning-fast final neighbor check when the interval hits 1.
* **Quick Sort** - The reigning champ of raw, in-memory speed. It picks a Pivot number, partitions all smaller elements to the left and larger elements to the right, and recursively locks each neighborhood down in-place with zero extra memory overhead.

### 8. Big O Notations
* **O(1)** - Constant Time - Performance never changes regardless of input size. Example: Accessing an array index directly.
* **O(log n)** - Logarithmic Time - The problem size is repeatedly divided in half. Example: Binary Search.
* **O(n)** - Linear Time - Performance grows proportionally with input size. Example: Linear Search.
* **O(n log n)** - Linearithmic Time - Highly efficient divide-and-conquer complexity used in advanced sorting. Example: Merge Sort and Quick Sort (average case).
* **O(n²)** - Quadratic Time - Usually caused by nested loops comparing every element. Example: Bubble Sort and Selection Sort.

### 9. Hash Table & Hash Functions
* **Hash Table** - A lightning-fast key-value data structure that stores data using computed array indexes for near-instant retrieval.
* **Separate Chaining** - Handles collisions by storing multiple elements in linked lists at the same index bucket.
* **Linear Probing** - Resolves collisions by searching sequentially for the next available empty slot.
   * **/Avoiding Clustering**
       * **Quadratic Probing** - Resolves collisions using quadratic jump intervals instead of sequential movement to reduce clustering.
       * **Double Hashing** - Uses a second hash function to calculate jump distances, producing highly distributed probing patterns and minimizing clustering further.

### 10. Binary Tree
* **Binary Tree** - A hierarchical data structure where each node can have at most two children: a left child and a right child.
* **Binary Search Tree** - A specialized binary tree where smaller values go to the left subtree and larger values go to the right subtree, enabling fast searching and sorting operations.
* **Insert Node** - Adds a new value into the correct BST position while maintaining tree ordering rules.
* **Delete Node** - Removes a node while preserving BST structure. Handles: Deleting a leaf node. Deleting a node with one child. Deleting a node with two children using inorder successor replacement.
* **Heap Sort** - A highly efficient sorting algorithm based on Binary Heaps. It repeatedly extracts the maximum (or minimum) element from the heap and rebuilds the structure until the array becomes sorted.
