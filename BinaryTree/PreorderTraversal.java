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

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre=new ArrayList<>();
        preOrder(root,pre);
        return pre;
    }
    public void preOrder(TreeNode root,List<Integer> pre){
        if(root==null)  return;
        pre.add(root.val);
        preOrder(root.left,pre);
        preOrder(root.right,pre);
    }

    //Iterative preorder traversal
    public static List<Integer> iterativePreorder(TreeNode root){
        List<Integer> order=new ArrayList<>();
        if(root==null){
            return order;
        } 
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root=st.pop();
            order.add(root.val);
            if(root.left!=null) st.push(root.left);
            if(root.right!=null) st.push(root.right);
        }
        return order;
    }
}
