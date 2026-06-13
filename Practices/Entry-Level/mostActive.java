/*
Problem 3: Most Active User

Description:
You are building an analytics dashboard for a social media platform.

Given a list of usernames representing user activity,
find the user who performed the most actions.

The method should return:

1. Username
2. Number of actions

Rules

1. Case Insensitive
   Usernames should be treated the same regardless of case.

   Example:
   "John"
   "john"
   "JOHN"

   all count as:
   "john"

2. Ignore Empty Entries

   Example:
   ""
   should not be counted.

3. If Multiple Users Tie

   Return the user that appeared first
   in the original activity list.

Examples

Input:
["John", "Mary", "John", "Bob", "John"]

Output:
john: 3


Input:
["Alice", "Bob", "Alice", "Bob"]

Output:
alice: 2

Explanation:
Both have 2 actions.

Alice appeared first.


Input:
["Tom", "", "Tom", "Jerry"]

Output:
tom: 2


Input:
["", "", ""]

Output:
No valid users found.


Method Signature:

public static void findMostActiveUser(String[] users)
*/

import java.util.*;
public class mostActive
{
    public static String mostActive(String s)
    {
        HashMap<String, Integer> map = new HashMap<>();
        String [] cleaned = s.replaceAll("[^a-z0-9\\s]", "").split("\\s");
        
        int count = 0;
        String winner = "";

        for(String user : cleaned)
        {
            if(user == null || user.trim().isEmpty())
            {
                continue;
            }

            map.put(user, map.getOrDefault(user, 0) + 1);

            if(map.get(user) > count)
            {
                count = map.get(user);
                winner = user;
            }
        }

        if(map.isEmpty())
        {
            return ("No valid input.");
        }

        return (winner + ":" + count);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        if(sc.hasNext())
        {
            String input = sc.nextLine();
            System.out.println(mostActive(input));
        }

        sc.close();
    }
}