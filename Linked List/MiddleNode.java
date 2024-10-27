public class MiddleNode {
    static ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}
class ListNode{
    int val;
    ListNode next;

    ListNode(){};
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
}
