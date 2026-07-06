import java.util.Scanner;

public class progressBar
{
    public static String generateProgressBar(double percentage) 
    {
        StringBuilder bar = new StringBuilder();
        
        // 1. Round percentage to the nearest 5%
        double rounded = Math.round(percentage / 5.0) * 5.0;
        
        // 2. Write your loop here to add the 10 blocks and the "->" separators...
        for(int i = 0; i < 10; i++)
        {
            if(rounded >= 10)
            {
                bar.append("[=]");
                rounded -= 10;
            }

            else if(rounded >= 5)
            {
                bar.append("[-]");
                rounded -= 5;
            }

            else
            {
                bar.append("[ ]");
            }

            if(i < 9)
            {
                bar.append(" -> ");
            }
        }

        return bar.toString();
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double input = sc.nextDouble();

        System.out.println(generateProgressBar(input));
    }
}