import java.util.*;

public class firstNonRepeating
{
    public static String find(String input)
    {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for(char c : input.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : map.keySet())
        {
            if(map.get(c) == 1)
            {
                return String.valueOf(c);
            }
        }

        return "No unique character";
    }


    public static void main(String args[])
    {
        System.out.println(find("swiss"));
    }
}