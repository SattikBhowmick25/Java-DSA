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
}
