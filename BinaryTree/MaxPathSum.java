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
        
    }
    private int finMaxPathSum(TreeNode node,int[] maxPath){
        if(node==null)  return 0;
        int[] leftMaxPath=new int[1];
        int[] rightMaxPath=new int[1];

        leftMaxPath[0]=Math.max(0,finMaxPathSum(node.left, maxPath));
        rightMaxPath[0]=Math.max(0,finMaxPathSum(node.right, maxPath));
    }
}
