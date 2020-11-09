package com.assignments;
/*Write an algorithm to reverse first 3 numbers, then next 3 numbers, then next 3 numbers, the number
        will be based on var k.
        Array = [3,2,4,7,0,3,1,5,8, 4] k=3
        Output = [4,2,3,3,0,7,8,5,1,4]*/

public class ReverseNumbersinArray {
    public static void reverse(int[] array,int k){
        int var;
        for(int index=0;index+k-1<array.length;index=index+k){
            int i=index;
             var=i+k-1;
            while(var>i) {
                 int temp= array[i];
                 array[i]=array[var];
                 array[var]=temp;
                var--;
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {3,2,4,7,0,3,1,5,8, 4};
        reverse(array,2);
        for(int j:array)
            System.out.println(j);
    }
}
