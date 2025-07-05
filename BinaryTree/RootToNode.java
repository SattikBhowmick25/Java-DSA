import java.util.*;

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
class PathFind{
    public List<Integer> rootToNode(TreeNode root, TreeNode node){
        List<Integer> path = new ArrayList<>();
        findPath(root, node, path);
        return path;
    }

    private boolean findPath(TreeNode root, TreeNode target, List<Integer> path) {
        if (root == null) return false;

        // Add current node
        path.add(root.val);

        // Check if current node is target
        if (root.val == target.val) return true;

        // Recur on left and right
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        // Backtrack: If the target node is not found in the branch tree then remove the node
        path.remove(path.size() - 1);
        return false;
    }
}
public class RootToNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        TreeNode target = root.left.left; // node with value 4

        PathFind r = new PathFind();
        System.out.println(r.rootToNode(root, target)); // Output: [1, 2, 4]

    }
}
