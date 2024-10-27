public class RemoveDuplicates {
    static Node removeDuplicates(Node head){
        if(head==null || head.next==null)
            return head;
        int val=head.data;
        Node temp=head;
        Node first=head;
        while(temp.next!=null){
            if(temp.data!=val){
                first.next=temp;
                temp.prev=first;
                first=temp;
                val=temp.data;
            }
            temp=temp.next;
        }
        if(temp.data==first.data)
            first.next=null;
        else{
            first.next=temp;
            temp.prev=first;
        }
        return head;
    }
}
//Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}
