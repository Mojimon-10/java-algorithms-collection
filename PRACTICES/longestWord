import java.util.*; 
import java.io.*;

class longestWord 
{

  public static String LongestWord(String sen)
  {
    // store longest
    String longest = "";
    // store current while reading thru the string
    String current = "";


    for(int i = 0; i < sen.length(); i++)
    {
      // will check word by word in the string and count them
      char ch = sen.charAt(i);

      // so if there is a char or digit, then store them in the current
      if(Character.isLetterOrDigit(ch))
      {
        current += ch;
      }

      else
      {
        // so if the current length is greater than longest then it will be stored in the longest instead
        if (current.length() > longest.length())
        {
          longest = current;
        }
        // current becomes empty again and goes back into looping
        current = "";
      }
    }
    
    if(current.length() > longest.length())
    {
      // last check after breaking the for loop if the last current is > than longest then replace the longest.
      longest = current;
    }

    return longest;
  }

  public static void main(String[] args) 
  { 
    //scanner for user input
    Scanner s = new Scanner(System.in);
    //calls out the longestword() with the user inputed string, while printing its result
    System.out.print(LongestWord(s.nextLine())); 
  }

}
