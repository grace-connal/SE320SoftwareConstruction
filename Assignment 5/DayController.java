import java.util.Scanner;

public class DayController
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int birthMonth;
        int birthDate;
        int birthYear;
        
        int currentMonth;
        int currentDate;
        int currentYear;
        while(true)
        {
            try
            {
                System.out.println("Enter your birth month as a number 1-12");
                birthMonth = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter your birth day as a number 1-31");
                birthDate = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter your birth year");
                birthYear = Integer.parseInt(scanner.nextLine());

                System.out.println("Enter the current month as a number 1-12");
                currentMonth = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the current day as a number 1-31");
                currentDate = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the current year");
                currentYear = Integer.parseInt(scanner.nextLine());

                break;
            }
            catch(NumberFormatException e)
            {
               System.out.println("That is not an integer. Please try again.");
            }
            catch(Exception e2)
            {
                System.out.println("Error creating day. Please try again.");
            }
        }
        scanner.close();
        Day birthDay = new Day(birthYear, birthMonth, birthDate);
        Day currentDay = new Day(currentYear, currentMonth, currentDate);
        System.out.println("There have been " + currentDay.daysFrom(birthDay) + " days since your birth day");
    }
}