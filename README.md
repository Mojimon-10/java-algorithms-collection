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

### 4. Linked List 
* **Linked List** - One-way node chain using forward indicators (next). Includes traversing, middle deletion, and inserting in between via pointer manipulation.
* **Double-Ended Linked List** - One-way node chain optimized with a tail pointer shortcut. Ideal foundation for high-performance Queues.
* **Doubly Linked List** - Two-way node highway utilizing both next and prev arrows. Allows bidirectional traversal and independent node deletion.

### 5. Iteration & Recursion
* **Iteration(Loops) / Iterator(Bookmark)** - Using for, while, and do-while control structures to repeat tasks sequentially with a fixed memory footprint.
* **Recursion (Self-Calls)** - The process where a method solves a problem by calling a smaller version of itself. Focuses on tracking the Base Case (the exit condition to prevent a stack overflow error) and the Recursive Case (stacking the execution frames).

### 6. Advanced Sorting Algorithms
* **Merge Sort** - A highly predictable, stable algorithm using recursive Divide and Conquer. It chops the array down to single elements and beautifully zips them back up into new, sorted temporary arrays.
* **Shell Sort** - An optimized variation of Insertion Sort that compares elements using jumping intervals (or gaps). It allows out-of-place numbers to "teleport" massive distances across the array before running a lightning-fast final neighbor check when the interval hits 1.
* **Quick Sort** - The reigning champ of raw, in-memory speed. It picks a Pivot number, partitions all smaller elements to the left and larger elements to the right, and recursively locks each neighborhood down in-place with zero extra memory overhead.

### 7. Big O Notations
