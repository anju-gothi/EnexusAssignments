package data.structure;

import java.util.HashSet;
import java.util.Set;

//3. WJP to check if linked list contains loop in Java? How to find the starting node of the loop
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
        next=null;
    }
}

public class LoopinLinkedList {
    Node head;
    public void insert(int data){
        Node temp=null;
        Node n = new Node(data);
        if(head==null){
            head=n;
        }else{
            temp=head;
            while(temp.next!=null)
            temp=temp.next;
            temp.next=n;
        }}

        public boolean checkLoop(Node n) {
            Set<Node> set = new HashSet<>();
            while (n!= null) {
                if (set.contains(n)) {
                    return true;
                } else {
                    set.add(n);
                    n=n.next;
                }
            }
            return false;
        }

        public void print(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
        }

    public static void main(String[] args) {
        LoopinLinkedList list = new LoopinLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println("Elements in the Linked List:");
        list.print();
        //create loop
        list.head.next.next.next=list.head;
        if(list.checkLoop(list.head)){
            System.out.println("There is loop in the Linked List");
        }else
        {
            System.out.println("No loop");
        }

    }
}
