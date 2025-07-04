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

public class RightLeftView{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)  return list;

        rightRecursion(root, 0, list);
        return list;
    }
    public void rightRecursion(TreeNode root, int level,List<Integer> list){
        if(root==null){
            return;
        }
        if(list.size()==level){
            list.add(root.val);
        }
        rightRecursion(root.right,level+1,list);
        rightRecursion(root.left, level+1, list);
    }
}