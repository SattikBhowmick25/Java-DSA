import java.util.ArrayList;

public class FindPairs {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Node left=head, right=head;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        while(right.next!=null) 
            right=right.next;

        while(left!=right && right.next!=left){
            int sum=left.data+right.data;
            if(sum==target){
                ArrayList<Integer> pair=new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);
                left=left.next;
                right=right.prev;
            }
            else if(sum<target){
                left=left.next;
            }
            else{
                right=right.prev;
            }
        }
        return ans;
    }
}
//Structure of Doubly Linked List
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int data)
	{
	    this.data = data;
	    next = prev = null;
	}
}