package data.structure;
// WJP to delete alternate nodes of a Linked List?
        /*Given a Singly Linked List, starting from the second node delete all alternate nodes of it.
        For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5,
        and if the given linked list is 1->2->3->4 then convert it to 1->3.*/
class Node3{
    int data;
    Node3 next;
    public Node3(int data){
        this.data=data;
        next=null;
    }
}
public class DeleteAltNodesInLinkedList {
            Node3 head=null;
      public void insertNode(int data){
          Node3 node = new Node3(data);
          Node3 temp;
          if(head==null){
              head=node;
          }else{
              temp=head;
              while(temp.next!=null){
                  temp= temp.next;
              }
              temp.next=node;
          }
      }
      public void deleteNode(){
          Node3 temp=head;
          Node3 dNode=null;
          while(temp.next!=null){
              dNode=temp.next;
             temp.next=dNode.next;
             if(dNode.next!=null)
            temp=dNode.next;
          }
      }

      public void display(){
          Node3 temp;
          temp=head;
          while(temp!=null){
              System.out.println(temp.data);
              temp=temp.next;
          }
      }

    public static void main(String[] args) {
          DeleteAltNodesInLinkedList list = new DeleteAltNodesInLinkedList();
          list.insertNode(1);
          list.insertNode(2);
          list.insertNode(3);
           list.insertNode(4);
           list.insertNode(5);
           System.out.println("Elements in the List:");
           list.display();
           list.deleteNode();
           System.out.println("Elements in the list after deletion:");
           list.display();

    }
}
