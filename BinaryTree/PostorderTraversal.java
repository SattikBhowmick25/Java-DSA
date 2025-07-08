import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postList=new ArrayList<>();
        postorder(root,postList);
        return postList;
    }
    public void postorder(TreeNode root,List<Integer> postList){
        if(root==null)  return;
        postorder(root.left,postList);
        postorder(root.right,postList);
        postList.add(root.val);
    }

    //Iterative postorder traversal using two stacks
    public static List<Integer> iterativePostorder(TreeNode root){
        List<Integer> postorder=new ArrayList<>();
        if(root==null)  return postorder;

        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);  
            if(root.left!=null)     s1.push(root.left);
            if(root.right!=null)     s1.push(root.right);
        }
        while(!s2.isEmpty()){
            postorder.add(s2.pop().val);
        }
        return postorder;
    }

    //Iterative postorder using only one stack
    public static List<Integer> postOrderTwoStacks(TreeNode root){
        Stack<TreeNode> st=new Stack<>();
        List<Integer> postorder=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null || !st.isEmpty()){
            if(cur!=null){
                st.push(cur);
                cur=cur.left;
            }
            else{
                TreeNode temp=st.peek();
                if(temp==null){
                    temp=st.pop();
                    postorder.add(temp.val);
                    while(!st.isEmpty() && temp==st.peek().right){
                        temp=st.pop();
                        postorder.add(temp.val);
                    }
                }
                else{
                    cur=temp;
                }
            }
        }
        return postorder;
    }
}
