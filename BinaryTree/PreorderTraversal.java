import java.util.ArrayList;
import java.util.List;

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
}
