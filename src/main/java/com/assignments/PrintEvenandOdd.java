package com.assignments;

import java.util.Arrays;

//WJP: given an array of elements print 1 even and 1 odd number in sorted
//        way. input : 7 4 8 3 2 10 6 5
//        output: 2 3 4 5 6 7 8
public class PrintEvenandOdd {

    public static void print(int[] array){
        Arrays.sort(array);
        for(int index=0;index<array.length;index++){
            if(index%2==0 && array[index]%2==0){
                System.out.println(array[index]);
            }else if(index%2!=0 && array[index]%2!=0){
                System.out.println(array[index]);
            }
        }
   }

    public static void main(String[] args) {
      int[] array={7,4,8,3,2,10,6,5};
        print(array);
    }
}
