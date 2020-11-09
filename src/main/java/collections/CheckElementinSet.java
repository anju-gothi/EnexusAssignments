package collections;



import java.util.LinkedHashSet;
import java.util.Set;

//Check if a particular element exists in Java LinkedHashSet.
public class CheckElementinSet {

    public static  boolean checkSet(Set<Integer> set, int element)
    {
        if(set.contains(element))
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(2);
        set.add(1);
       System.out.println(checkSet(set,1));
    }
}
