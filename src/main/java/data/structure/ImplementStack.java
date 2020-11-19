package data.structure;

//2. Write a Java program to implement Stack in Java?
import java.util.Scanner;

public class ImplementStack {
    int stackSize;
    int[] stackArray;
    int pointer;

    public ImplementStack(int size){
          this.stackSize=size;
          this.stackArray=new int[stackSize];
          this.pointer=-1;
    }
    public void push(int element){
        stackArray[++pointer]=element;
    }
    public int pop(){
        return stackArray[pointer--];
    }
    public int peek(){
    return stackArray[pointer];
    }
    public boolean isEmpty(){
        if(pointer==-1)
            return true;
        else
            return false;
    }
    public boolean isFull(){
        return (pointer==stackSize-1);
    }

    public static void main(String[] args) {
        ImplementStack stack = new ImplementStack(5);
        while(!stack.isFull()){
            System.out.println("Enter element in Stack:");
            Scanner in = new Scanner(System.in);
            int value=in.nextInt();
            stack.push(value);
        }
        System.out.println("Element on the top:"+stack.peek());

        System.out.println("Elements in the stack are:");
        while(!stack.isEmpty()){
            int value =stack.pop();
           System.out.println(value);
        }
    }
}
