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
    public static String start(String s)
    {
        HashMap<String, Integer> users = new HashMap<>();
        int count = 0;
        String winner = "";

        String[] cleaned = s.toLowerCase().replaceAll("[^a-z0-9\\s]", "").split("\\s");

        for(String x : cleaned)
        {
            if (x == null || x.trim().isEmpty()) 
            {
                continue;
            }

            users.put(x, users.getOrDefault(x, 0) + 1);

            if(users.get(x) > count)
            {
                count = users.get(x);
                winner = x;
            }

        }

        if(users.isEmpty())
        {
            return "No valid users found.";
        }

        return (winner + ": " + count);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext())
        {
            String input = sc.nextLine();
            System.out.println(start(input));
        }

        sc.close();
    }
}