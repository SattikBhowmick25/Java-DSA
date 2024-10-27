public class Intersection {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp2=headB;
        while(temp2!=null){
            ListNode temp1=headA;
            while(temp1!=null){
                if(temp1==temp2)    return temp1;
                temp1=temp1.next;
            }
            temp2=temp2.next;
        }
        return null;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){
        this.val=0;
        this.next=null;
    }
    ListNode(int val){
        this.val=val;
        this.next=null;
    }
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}