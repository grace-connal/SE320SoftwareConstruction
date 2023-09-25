import java.util.Scanner;

public class Array
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner(System.in);
        int nums[] = new int[100];
        for (int i = 0; i < nums.length; i++)
        {
            nums[i] = (int)(Math.random() * 101 + 1);
        }
        while(true)
        {
            try
            {
                System.out.println("Please enter an integer between 0 and 99");
                System.out.println();
                System.out.println("The number is " + nums[Integer.valueOf(scan.nextLine())]);
                break;
            }
            catch(NumberFormatException e)
            {
               System.out.println("That is not an integer. Please try again.");
            }
            catch(IndexOutOfBoundsException e2)
            {
                System.out.println("That number is not between 0 and 99. Please try again.");
            }
        }
        scan.close();
    }
}