import java.util.*;
import java.io.*;

public class TreeSets
{
    public static void main(String[] args)
    {
        TreeSet treeSet = new TreeSet();

        try(FileReader fileReader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);)
        {
            while (bufferedReader.ready())
            {
                treeSet.add(bufferedReader.readLine());
            }

            bufferedReader.close();
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.println("No file called input.txt could be found");
        }

        System.out.println(treeSet);

    }
}