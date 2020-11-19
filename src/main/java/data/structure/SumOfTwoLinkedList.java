package data.structure;
//9. How do you find the sum of two linked lists using Stack?
/*Given two numbers which are represented using linked lists as shown below.
Your program should return the reference to a new linked list which stores the sum of given two numbers.

        Numbers are represented as following:
        Number 99971, corresponding linked list: 9->9->9->7->1
        Number 998,   corresponding linked list: 9->9->8*/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SumOfTwoLinkedList{
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    //Method that will accept two parameter as two linked list and convert them into two stacks
    public List<Integer> sumOfList(List<Integer> list1, List<Integer> list2){
         stack1= new Stack<>();
         stack2=new Stack<>();
        for(int ele:list1)
           stack1.push(ele);
        for(int ele:list2)
            stack2.push(ele);
       List<Integer> sumList= addNumbers();
       return sumList;
    }
    public List<Integer> addNumbers(){
        List<Integer> list3=new ArrayList<>();
        Stack<Integer> stack3= new Stack<>();
        int sum=0;
        int quo=0;
        int carry=0;
        while(!stack1.empty()&&!stack2.empty()){
            sum=(stack1.pop()+stack2.pop()+carry);
            quo=sum%10;
            carry=sum/10;
            stack3.push(quo);
        }
        if(!stack1.empty()){
            while(!stack1.empty()){
            sum=(stack1.pop()+carry);
             quo=sum%10;
            carry=sum/10;
            stack3.push(quo);}
        }
        if(!stack2.empty()){
            while(!stack2.empty()){
                sum=(stack2.pop()+carry);
                quo=sum%10;
                carry=sum/10;
            stack3.push(quo);}
        }

        if(carry>0)
            stack3.push(carry);
        //putting stack elements in the list
        while(!stack3.empty()){
           int element= stack3.pop();
            list3.add(element);
        }
        return list3;
    }

    public static void main(String[] args) {
        SumOfTwoLinkedList sumObj=new SumOfTwoLinkedList();
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        list1.add(1);
        list1.add(2); //1239
        list1.add(3);
        list1.add(9);
        list2.add(1);
        list2.add(9); //191
        list2.add(1);
       List<Integer> finalList= sumObj.sumOfList(list1,list2);
       System.out.println("Sum of two Linked List is:"+finalList);
    }
}
