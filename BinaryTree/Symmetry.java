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
public class Symmetry {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;
        return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        if(left.val!=right.val)
            return false;
        
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
