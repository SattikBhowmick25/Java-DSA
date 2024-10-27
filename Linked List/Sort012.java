public class Sort012 {
    static Node segregate(Node head) {
        if(head==null || head.next==null)   return head;
        Node zeroHead=new Node(-1);
        Node oneHead=new Node(-1);
        Node twoHead=new Node(-1);

        Node temp=head;
        Node zero=zeroHead;
        Node one=oneHead;
        Node two=twoHead;
        while(temp!=null){
            switch(temp.data){
                case 0: zero.next=temp; 
                        zero=zero.next;
                        break;
                case 1: one.next=temp; 
                        one=one.next;
                        break;
                case 2: two.next=temp; 
                        two=two.next;
                        break;
            }
            temp=temp.next;
        }
        zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next=twoHead.next;
        two.next=null;
        return zeroHead.next;
    }
}
class Node{
    int data;
    Node next;
    Node(){
        this.data=0;
        this.next=null;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
    Node(int val,Node next){
        this.data=val;
        this.next=next;
    }
}
