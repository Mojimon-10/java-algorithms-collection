
import java.util.*;

public class reverse
{
    public static List<Integer> reverseOrder(int[] i)
    {
        LinkedList<Integer> reverse = new LinkedList<>();

        for(int number : i)
        {
            reverse.addFirst(number);
        }

        return reverse;
    }
    public static void main(String args[])
    {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(reverseOrder(input));
    }
}