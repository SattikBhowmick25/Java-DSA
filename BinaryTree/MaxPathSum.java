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
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max={Integer.MIN_VALUE};
        findMaxPathSum(root, max);
        return max[0];
    }
    private int findMaxPathSum(TreeNode node,int[] maxPath){
        if(node==null)  return 0;

        int leftMaxPath=Math.max(0,findMaxPathSum(node.left, maxPath));
        int rightMaxPath=Math.max(0,findMaxPathSum(node.right, maxPath));

        maxPath[0]=Math.max(maxPath[0],leftMaxPath+rightMaxPath+node.val);

        return Math.max(leftMaxPath,rightMaxPath)+node.val;
    }
}
