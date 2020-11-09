package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Write a program to convert HashSet to Array?
public class HashsetToArray {
    public static Object[] convert(Set<Integer> set){
        //first method
       Object[] array= set.toArray();
       //second method looping
       return array;
    }

    public static void main(String[] args) {
        Set<Integer> set=new HashSet<>();
    set.add(1);
    set.add(2);
    Object[] array=convert(set);
        for(Object obj:array)
        System.out.println(obj);



}}
