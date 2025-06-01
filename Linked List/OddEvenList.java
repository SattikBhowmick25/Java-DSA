public class OddEvenList{
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead=new ListNode(-1),oddTail=oddHead;
        ListNode evenHead=new ListNode(-1),evenTail=evenHead;
        ListNode cur=head,temp;
        int index=1;
        while(cur!=null){
            temp=cur;
            cur=cur.next;
            temp.next=null;
            if(index%2!=0){
                oddTail.next=temp;
                oddTail=temp;
            }
            else{
                evenTail.next=temp;
                evenTail=temp;
            }
            index++;
        }
        oddTail.next=evenHead.next;
        return oddHead.next;
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
