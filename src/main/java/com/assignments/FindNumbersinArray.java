package com.assignments;

import java.util.HashMap;
import java.util.Map;

/*An array contains total of 10 mobile numbers write a program to find the total no of zero’s, one’s,
        two’s…untill….. nine’s*/
public class FindNumbersinArray {
    public static void findNumbers(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        for(int index=0;index<array.length;index++){
            int number= array[index];
            while(number!=0){
                int digit = number%10;
                if(map.containsKey(digit)){
                    int value = map.get(digit);
                    value++;
                    map.put(digit,value);
                }else{
                    map.put(digit,1);
                }

                int quetient = number/10;
                number=quetient;
            }
        }
        System.out.println(map);
    }
    public static void main(String[] args) {
         int[] array={1234,1234,12};
         findNumbers(array);
    }
}
