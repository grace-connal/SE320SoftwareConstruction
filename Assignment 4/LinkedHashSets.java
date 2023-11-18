import java.util.*;

public class LinkedHashSets
{
    public static void main(String[] args)
    {
        LinkedHashSet<String> lhs1 = new LinkedHashSet<String>();
        lhs1.add("George");
        lhs1.add("Jim");
        lhs1.add("John");
        lhs1.add("Blake");
        lhs1.add("Kevin");
        lhs1.add("Michael");

        LinkedHashSet<String> lhs2 = new LinkedHashSet<String>();
        lhs2.add("George");
        lhs2.add("Katie");
        lhs2.add("Kevin");
        lhs2.add("Michelle");
        lhs2.add("Ryan");

        LinkedHashSet<String> union = (LinkedHashSet<String>)lhs1.clone();
        union.addAll(lhs2);
        System.out.println("The union of the two hash sets is " + union);
        
        LinkedHashSet<String> difference = (LinkedHashSet<String>)lhs1.clone();
        difference.removeAll(lhs2);
        System.out.println("The difference of the two hash sets is " + difference);

        LinkedHashSet<String> intersection = (LinkedHashSet<String>)lhs1.clone();
        intersection.retainAll(lhs2);
        System.out.println("The intersection of the two hash sets is " + intersection);
        
    }
}