public class SortLL {
    static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode middle=findMiddle(head);

        ListNode right=middle.next;
        middle.next=null;
        ListNode left=head;

        left=sortList(left);
        right=sortList(right);
        return mergeTwoSortedLL(left, right);
    }

    static ListNode mergeTwoSortedLL(ListNode list1,ListNode list2){
        ListNode dummyNode=new ListNode();
        ListNode temp=dummyNode;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next=list1;
        }
        else if(list2!=null){
            temp.next=list2;
        }
        return dummyNode.next;
    }

    static ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        if(head==null || head.next==null) return head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=null;
        ListNode head=sortList(node1);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
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