package data.structure;

class Node1{
    int data;
    Node next;
    public Node1(int data){
        this.data=data;
        next=null;
    }
}
public class PrintDataInLinkedList {
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

    public void print(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        PrintDataInLinkedList list = new PrintDataInLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        System.out.println("Elements in the Linked List:");
        list.print();
}
}
