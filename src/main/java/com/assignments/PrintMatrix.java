package com.assignments;
/*Write a code on to print the output matrix from input
        matrix Input -> [1 2 3 output -> [7 4 1
                         4 5 6           8 5 2
                         7 8 9]          9 6 3]*/
public class PrintMatrix {

    public static void print(int[][] matrix,int rows,int cols){
     for(int col=0;col<cols;col++){
         for(int row=rows-1;row>=0;row--){
             System.out.print(matrix[row][col]+" ");
         }
         System.out.println("\n");
     }
    }

    public static void main(String[] args) {
         int[][] matrix={{1,2,3},
                         {4,5,6}
                         ,{7,8,9}};
         print(matrix,3,3);
    }
}
