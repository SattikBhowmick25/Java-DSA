public class DeleteKey {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==x){
                if(temp.next!=null && temp.prev!=null){
                    //case when a node in between has x
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                }
                else if(temp.next==null){
                    //case when the last node has x
                    temp.prev.next=null;
                }
                else if(temp.prev==null){
                    //Case when the head node has x
                    head=temp.next;
                    head.prev=null;
                }
                else if(temp.next==null && temp.prev==null){
                    return null;
                }
            }
            temp=temp.next;
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