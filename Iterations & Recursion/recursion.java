/* RECURSION MASTERED: THE BOX INSIDE A BOX

Recursion is like a box inside a box. In order to answer the original equation, 
you have to dig deeper and solve what's inside first. It is basically a self-call.

public class recursion
{
    public static int factorial(int n) // Let's say you input 5
    {
        // THE BASE CASE (The Stop Button); since n = 5 it skips this
        if (n == 1) 
        {
            return 1;
        }

        // THE RECURSIVE STEP (The Self-Call)
        // It freezes the current number and calls factorial on (5 - 1)
        return n * factorial(n - 1); 
        
        // DOWN PHASE (Digging into the boxes and bookmarking):
        // 5 * CALL METHOD(4) -> Remember this, go deeper with 4
        // 4 * CALL METHOD(3) -> Remember this, go deeper with 3
        // 3 * CALL METHOD(2) -> Remember this, go deeper with 2
        // 2 * CALL METHOD(1) -> Remember this, go deeper with 1
        // 1                  -> HITS THE BASE CASE! We found the missing piece!
               
        // UP PHASE (Climbing back up to finish the frozen equations):
        // 2 * 1  = 2     (factorial(2) becomes 2)
        // 3 * 2  = 6     (factorial(3) becomes 6)
        // 4 * 6  = 24    (factorial(4) becomes 24)
        // 5 * 24 = 120   (The final master answer!)
    }
}
*/


public class recursion 
{

    public static void countDown(int seconds) 
    {
        // 1. THE BASE CASE (The Stop Button)
        if (seconds == 0) 
        {
            System.out.println("BLAST OFF!!!");
            return; // Stops the recursion!
        }

        // 2. THE WORK
        System.out.println(seconds + " seconds remaining...");

        // 3. THE RECURSIVE STEP (The Self-Call)
        // We pass in (seconds - 1) to bring us one step closer to 0
        countDown(seconds - 1); 
    }

    public static void main(String[] args) 
    {
        System.out.println("Starting countdown...");
        countDown(3); // Start the countdown from 3!
    }
}