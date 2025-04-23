import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
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

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inList=new ArrayList<>();
        inorder(root,inList);
        return inList;
    }
    public void inorder(TreeNode root,List<Integer> inList){
        if(root==null)  return;
        inorder(root.left,inList);
        inList.add(root.val);
        inorder(root.right,inList);
    }
    //Iterative inorder
    public List<Integer> iterativeInorderTraversal(TreeNode root){
        List<Integer> inorder=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode node=root;
        while(true){
            if(node!=null){
                st.push(node);
                node=node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node=st.pop();
                inorder.add(node.val);
                node=node.right;
            }
        }
        return inorder;
    }
}
