package collections;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/*Basic Java program to Remove specified element from TreeSet example
        9. Remove all elements LinkedHashSet*/
public class TreesetLinkedHashset {
    public static void removeElement(Set<Integer> set,int element){
        if(set.contains(element))
        set.remove(element);

    }
    public static void main(String[] args) {
        Set<Integer> set1 = new TreeSet<>();
        Set<Integer> set2=new LinkedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        removeElement(set1,1);
        System.out.println(set1);
        removeElement(set2,3);
        System.out.println(set2);

    }
}
