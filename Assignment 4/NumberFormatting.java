import java.text.*;
import java.util.*;

public class NumberFormatting
{
    public static void main(String[] args)
    {
        double number = 12345.678;

        Locale uk_Locale = new Locale("en", "UK");
        NumberFormat ukNumberFormat = NumberFormat.getInstance(uk_Locale);
        ukNumberFormat.setMaximumFractionDigits(2);
        System.out.println("The number 12345.678 in the United Kingdom locale is " + ukNumberFormat.format(number));

        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("The number 12345.678 in US currency is " + usCurrencyFormat.format(number));

        NumberFormat parseFormat = NumberFormat.getInstance();
        try
        {
        System.out.println("12,345.678 parsed into a number is " + parseFormat.parse("12,345.678"));
        }
        catch(ParseException e)
        {
            System.out.println("String could not be parsed into a number");
        }
    }
}