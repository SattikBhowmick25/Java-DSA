public class AddOne {
    static int helper(Node temp){
        if(temp==null)  return 1;
        int carry=helper(temp.next);
        temp.data=temp.data+carry;
        if(temp.data<10)    return 0;
        temp.data=0;
        return 1;
    }
    static Node addOne(Node head) {
        int carry=helper(head);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    static Node addOne1(Node head) {
        head=reverse(head);
        Node temp=head;
        int carry=1;
        while(temp!=null){
            temp.data+=carry;
            if(temp.data<10){
                carry=0;
                break;
            }    
            temp.data=0;
            temp=temp.next;
        }
        head=reverse(head);
        if(carry==1){
            Node node=new Node(1);
            node.next=head;
            head=node;
        }
        return head;
    }
    static Node reverse(Node head){
        if(head==null || head.next==null)   return head;
        Node prev=null;
        Node cur=head;
        while(cur!=null){
            Node fwd=cur.next;
            cur.next=prev;
            prev=cur;
            cur=fwd;
        }
        return prev;
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