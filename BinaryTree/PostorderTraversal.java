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
}
