package data.structure;

import com.google.gson.internal.$Gson$Preconditions;
//To implement Circular queue, we have to replace rear++ in enque() to rear=(rear+1)%size.In dqueue()
//front=(front+1)%size
public class ImplementQueue {
    int maxSize;
    int[] queueArray;
    int front;
    int rear;
    public ImplementQueue(int size){
        this.maxSize=size;
        queueArray=new int[maxSize];
        rear=-1;
        front=0;
    }

    //For insertion
    public void enqueue(int element){
        if(!isFull())
        queueArray[++rear]=element;
        else
            System.out.println("Queue is full");
    }
    //For deletion
    public void dqueue(){
        int deletedElement=0;
        if(rear>-1){
            deletedElement= queueArray[front++];
        System.out.println("Element "+deletedElement+ " is deleted"); }
        else
            System.out.println("Queue is Empty");
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
        return rear==-1;
    }
  public void display(){
        int start=front;
        while(start<=rear){
            System.out.println(queueArray[start]);
            start++;
        }
  }

    public static void main(String[] args) {
        ImplementQueue queue= new ImplementQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println("Elements in the queue:");
        queue.display();
        //delete the elemenet
        queue.dqueue();
        System.out.println("Elements after deleting an element");
        queue.display();


    }

}
