public class DelMiddle {
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode delp=slow;
        if(fast.next==null) return null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            delp=slow;
            slow=slow.next;
        }
        delp.next=delp.next.next;
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