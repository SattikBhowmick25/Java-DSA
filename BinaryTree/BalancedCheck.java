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
public class BalancedCheck {
    //Brute force approach-O(n^2)
    public boolean isBalanced(TreeNode root) {
        //Base case: if the root is null then height is balanced as and empty tree is always balanced
        if(root==null){
            return true;
        }

        //Calculating the height of the left and right subtree
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);

        if(Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right)){
            return true;
        }

        return false;
    }
    private int getHeight(TreeNode root){
        if(root==null)  return 0;
        int leftHeight=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    //Optimal approach-O(n)
    public boolean isBalancedOptimal(TreeNode root){
        return dfsHeight(root)!=-1;
    }
    private int dfsHeight(TreeNode root){
        if(root==null)  return 0;

        int leftHeight=dfsHeight(root.left);
        if(leftHeight==-1)  return -1;

        int rightHeight=dfsHeight(root.right);
        if(rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1)
            return -1;
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}
