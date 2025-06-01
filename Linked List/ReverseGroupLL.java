public class ReverseGroupLL{
    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;
        while(temp!=null){
            ListNode kthNode=findKthNode(temp, k);
            if(kthNode==null){
                if(prevLast!=null){
                    prevLast.next=temp;
                }
                break;
            }

            ListNode nextNode=kthNode.next;
            kthNode.next=null;
            reverseLL(temp);

            if(temp==head){
                head=kthNode;
            }
            else{
                prevLast.next=kthNode;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }
    static ListNode reverseLL(ListNode head){
        ListNode prev=null;
        ListNode cur=head;
        if(head==null || head.next==null){
            return head;
        }
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=prev;
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
    static ListNode findKthNode(ListNode temp,int k){
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
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
