package com.assignments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given input string= “ABCAABCAEBE” find which character is duplicated least number of times. o/p= ”E,
        C”
*/
public class DuplicateChar {

    public static  List<Character> findDuplicate(String st){
        int len = st.length();
        if(len<=1)
            return null;
        Map<Character,Integer> map = new HashMap<>();
        for(int index=0;index<len;index++){
            char ch = st.charAt(index);
            if(map.containsKey(ch)){
                int value = map.get(ch);
                value++;
                map.put(ch,value);
            }
            else
                map.put(ch,1);
        }
          int leastOccurance=len;
        List<Character> list = new ArrayList<>();
        Character minchar=' ';
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int value = entry.getValue();
            if(value<leastOccurance){
                leastOccurance=value;
                minchar=entry.getKey();
            }
        }
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            int value=entry.getValue();
            if(value==leastOccurance && entry.getKey()!=minchar){
                list.add(entry.getKey());
            }
        }
        list.add(minchar);
        return list;
    }
    public static void main(String[] args) {
        List<Character> list = findDuplicate("ABCAABCAEBE");
        System.out.println("Least number of Characters:"+list);

    }
}
