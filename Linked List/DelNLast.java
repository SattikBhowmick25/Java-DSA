public class DelNLast {
    static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow=head, fast=head;
        while(n>0){
            if(fast==null) break;
            fast=fast.next;
            n--;
        }
        if(n>0) return null;
        if(fast==null)  return head.next;

        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
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
