import java.util.*; 
import java.io.*;

class firstFactorial
{

  public static int FirstFactorial(int num) 
  {
    // variable that stores the factorial and will display the final ans
    //we start at 1 because factorial uses multiplication
    int factorial = 1;
    
    //this loop starts from num and counts down until 1.
    // so if 4 the loop will use 4 3 2 1
    for(int i = num; i >= 1; i--)
    {
      // factorial = 1 * 4 = 4, so 4 becomes the new data in the factorial
      // = 4 * 3 / factorial * i since i decreased it will be now 3.
      // = 12 * 2 and so on
      factorial = factorial * i;
    }

    return factorial;
  }

  public static void main (String[] args) 
  {  
    // scanner here for user input
    Scanner s = new Scanner(System.in);
    // then call out the method with its user inputed value, then it will print the result.
    System.out.print(FirstFactorial(s.nextLine())); 
  }

}