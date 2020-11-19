package data.structure;

//5. WJP to Reverse a linked list in Java

 class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data=data;
        this.next=null;
    }
        }
public class ReverseLinkedList {
  static ListNode head=null;
  public void insertNode(int value){
      ListNode n= new ListNode(value);
      ListNode temp;
      if(head==null){
          head=n;
      }else{
          temp=head;
          while(temp.next!=null){
              temp=temp.next;
          }
          temp.next=n;
      }
  }
  public ListNode reverseList(ListNode n){
      ListNode pre=null;
      ListNode nextNode=null;
      ListNode current=n;
      while(current!=null){
          nextNode=current.next;
          current.next=pre;
          pre=current;
          current=nextNode;
      }
      n=pre;
      return n;
  }

  public void print(ListNode node){
      ListNode temp = node;
      while(temp!=null){
          System.out.println(temp.data);
          temp=temp.next;
      }

  }

    public static void main(String[] args) {
      ReverseLinkedList list = new ReverseLinkedList();
        list.insertNode(1);
        list.insertNode(2);
        list.insertNode(3);
        list.insertNode(4);
        list.insertNode(5);
        System.out.println("Values in the linked list:");
        list.print(head);
        System.out.println("Linked List in the reverse Order:" );
        ListNode head1=list.reverseList(head);
        list.print(head1);

    }
}
