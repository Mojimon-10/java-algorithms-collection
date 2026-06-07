/*
Problem 1: Browser History Tracker

Description:
You are building a simple browser history feature.

Given a sequence of website visits, keep track of the
most recent websites visited.

Rules

1. History Capacity
   The browser can store a maximum of:
   5 websites

2. Visit Website
   When a new website is visited:
   - Add it to the history.

3. Remove Oldest
   If adding a new website causes the history
   to exceed 5 websites:
   - Remove the oldest website.

4. Duplicate Visits
   If a website is visited again:
   - Remove its previous occurrence.
   - Add it back to the end of the history.
   - It becomes the most recently visited website.

5. Output
   Return the history from oldest to newest
   joined by:

   " -> "

Examples

Input:
["google.com", "youtube.com", "github.com"]

Output:
google.com -> youtube.com -> github.com


Input:
[
 "google.com",
 "youtube.com",
 "github.com",
 "stackoverflow.com",
 "reddit.com",
 "chatgpt.com"
]

Output:
youtube.com -> github.com -> stackoverflow.com -> reddit.com -> chatgpt.com

Explanation:
The capacity is 5.
google.com is removed because it is the oldest.


Input:
[
 "google.com",
 "youtube.com",
 "github.com",
 "google.com"
]

Output:
youtube.com -> github.com -> google.com

Explanation:
google.com was visited again.
Remove the old google.com entry and add it to the end.
*/

import java.util.*;

public class browserHistory
{
    public static String start(String[] s)
    {
        ArrayList<String> history = new ArrayList<>();

        for(String current : s)
        {
            if(history.contains(current))
            {
                history.remove(current);
            }

            history.add(current);

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
        String[] s = sc.nextLine().split("\\s");

        System.out.println(start(s));

        sc.close();
    }
}