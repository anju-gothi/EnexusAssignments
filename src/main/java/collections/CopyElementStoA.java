package collections;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Java program to Copy all elements of Java HashSet to an ObjectArray
public class CopyElementStoA {
    public static void copyElement(Set<Integer> set){
        int length = set.size();
        Object[] array=new Object[length];
        //1st Method:covert set to Array
       // array=set.toArray();
        //Second Method copy each element
        Iterator itr =set.iterator();
        for(int index=0;index<length;index++){
            if(itr.hasNext()){
               array[index]= itr.next();
            }
        }

    //print array
        for(int index=0;index<length;index++){
            System.out.println(array[index]);
        }

    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        copyElement(set);

    }
}
