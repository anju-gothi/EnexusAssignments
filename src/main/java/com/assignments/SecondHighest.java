package com.assignments;
// Write a Java Program to find the second-highest number in an user array.
public class SecondHighest {

    public static int findSecondHighest(int[] array){
        int length = array.length;
        if(length<=1)
           return array[0];
        int highest=array[0];
        int secondHighest=array[1];
        for(int index=1;index<length;index++){
            if(highest<array[index]){
                secondHighest=highest;
                highest=array[index];
            }else if(array[index]>secondHighest && array[index]<highest){
                secondHighest=array[index];
            }
        }
        return secondHighest;
    }
    public static void main(String[] args) {
        int[] array={3,2,5,4,6,8,11,9,8,7,10};
        System.out.println("Second Heighest number is:"+findSecondHighest(array));
    }

}
