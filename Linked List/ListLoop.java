import java.util.HashMap;
import java.util.Map;


public class ListLoop {
    //TC-O(N)  SC-O(1)
    static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)  return true;
        }
        return false;
    }
    static ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null && slow!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    static ListNode detectCycleHash(ListNode head) {
        Map<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        while(temp!=null){
            if(map.getOrDefault(temp,0)==1)    return temp;
            map.put(temp,map.getOrDefault(temp, 0)+1);
            temp=temp.next;
        }
        return null;
    }
    static int countNodesinLoop(ListNode head) {
        int count=0;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                count++;
                fast=fast.next;
                while(slow!=fast){
                    fast=fast.next;
                    count++;
                }
                return count;
            }
        }
        return count;
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
