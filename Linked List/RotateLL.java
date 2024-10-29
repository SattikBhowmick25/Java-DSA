public class RotateLL {
    static ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
            return head;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        int newK=n-(k%n);
        if(newK==n) return head;
        newK--; 
        temp=head;
        while(temp!=null && newK>0){
            temp=temp.next;
            newK--;
        }
        ListNode newHead=temp.next;
        temp.next=null;
        temp=newHead;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        return newHead;
    }
    static ListNode rotateRightLL(ListNode head, int k){
        if(head==null || head.next==null)   return head;

        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        temp.next=head; //Making the LL circular by connecting the last to head
        k=k%len;
        int end=len-k;
        while(end>0){
            temp=temp.next;
            end--;
        }
        head=temp.next;
        temp.next=null;

        return head;
    }
}
class ListNode{
    int val;
    ListNode next;
    
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}
