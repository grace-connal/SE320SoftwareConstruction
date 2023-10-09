import java.util.ArrayList;

public class NumberSet
{
       public static void main(String[] args) 
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(14);
            list.add(24);
            list.add(14);
            list.add(42);
            list.add(25);
            ArrayList<Integer> newList = removeDuplicates(list);
            System.out.print(newList);
        }
        public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
        {
            ArrayList<E> uniqueList = new ArrayList<E>();
            for(E element: list)
            {
                if (uniqueList.contains(element) == false)
                {
                    uniqueList.add(element);
                }
            }
            return uniqueList;
        }
}