import java.util.Scanner;

public class AssertUserInput
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Integer userInput = null;
        while (userInput == null)
        {
            try 
            {
                System.out.println("Enter a number between 1 and 10");
                userInput = Integer.valueOf(scanner.nextLine());
            }
            catch (NumberFormatException e) 
            {
                userInput = null;
            }
        }
        scanner.close();

        try
        {
            assert userInput >= 0;
            assert userInput <= 10;
        }
        catch (AssertionError e)
        {
            throw new AssertionError("The entered number is out of range");        }
    }
}