/*
Problem: Delivery Tracking System

Description:
You are building a delivery analytics system.

Given a list of delivery records,
analyze driver performance.

Each record contains:

driverName status

Example:

John Delivered
Mary Failed
john Delivered


Rules:
1. Case Insensitive

Driver names are not case sensitive.

Example:

John
JOHN
john

are the same driver.

2. Ignore Invalid Records

Ignore if:
- driver name is empty
- status is not:
    Delivered
    Failed

3. Track Each Driver

For every driver store:
- total deliveries
- successful deliveries
- failed deliveries


4. Find Best Driver
The best driver is:
Highest number of Delivered packages



5. Tie Rule
If two drivers have the same delivered count:
Return the driver who appeared first.



6. Output
driverName: delivered, failed

Examples:
Input:

[
 "John Delivered",
 "Mary Failed",
 "john Delivered",
 "Bob Delivered"
]


Processing:

john:
delivered = 2
failed = 0

mary:
delivered = 0
failed = 1

bob:
delivered = 1
failed = 0


Output:

john: 2, 0



Example 2:
Input:

[
 "Alice Delivered",
 "Bob Delivered",
 "Alice Failed",
 "Bob Delivered"
]


Output:
bob: 2, 0

Example 3:
Input:
[
 "Tom Unknown",
 "",
 " "
]


Output:
No valid drivers found.

*/

import java.util.*;

public class deliveryTracking
{
    public static String findBestDriver(String[] deliveries)
    {
        LinkedHashMap<String,Integer> delivered = new LinkedHashMap<>();
        LinkedHashMap<String,Integer> failed = new LinkedHashMap<>();

        for(String record : deliveries)
        {
            String[] data = record.trim().split("\\s+");

            if(data.length != 2)
            {
                continue;
            }

            String driver = data[0].toLowerCase();
            String status = data[1].toLowerCase();

            if(driver.isEmpty())
            {
                continue;
            }

            if(status.equals("delivered"))
            {
                delivered.put(driver, delivered.getOrDefault(driver, 0)+1);
            }

            else if(status.equals("failed"))
            {
                failed.put(driver, failed.getOrDefault(driver, 0)+1);
            }

        }

        if(delivered.isEmpty())
        {
            return "No valid drivers found.";
        }

        String winner = "";
        int highest = -1;


        for(String driver : delivered.keySet())
        {
            if(delivered.get(driver) > highest)
            {
                highest = delivered.get(driver);
                winner = driver;
            }
        }

        return winner + ": "
            + delivered.get(winner)
            + ", "
            + failed.get(winner);
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] input = line.split(",");

        System.out.println(findBestDriver(input));
    }
}