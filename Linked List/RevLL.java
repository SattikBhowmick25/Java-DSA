public class RevLL{
    static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        ListNode nxt;
        while(temp!=null){
            nxt=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nxt;
        }
        return prev;
    }
    static ListNode reverseListRecursive(ListNode head){
        if(head==null || head.next==null)
            return null;
        
        ListNode newHead=reverseListRecursive(head);
        ListNode nxt=head.next;
        nxt.next=head;
        head.next=null;
        
        return newHead;
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