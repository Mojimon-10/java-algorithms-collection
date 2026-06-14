import java.util.*;

public class LRUCache
{
    public static String cache(String[] s)
    {
        ArrayList<String> history = new ArrayList<>();

        for(String input : s)
        {
            if(history.contains(input))
            {
                history.remove(input);
            }

            history.add(input);

            if(history.size() > 5)
            {
                history.remove(0);
            }

        }

        return (String.join(" -> ", history));
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s");

        System.out.println(cache(input));

        sc.close();
    }
}