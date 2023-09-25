import java.util.Scanner;

public class Sum 
{
    public static void main(String[] args) 
    {
        Integer[] nums = new Integer[2];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++)
        {
            while(nums[i] == null)
            {
                try
                {
                    System.out.println("Please enter an integer");
                    nums[i] = Integer.valueOf(scan.nextLine());
                }
                catch(NumberFormatException e)
                {
                   System.out.println("That is not an integer. Please try again.");
                }
            }
            System.out.println("Number " + (i + 1) + " is " + nums[i]);
        }
        int sum = nums[0] + nums[1];
        System.out.println("The sum is " + sum);
        scan.close();
    }
}
