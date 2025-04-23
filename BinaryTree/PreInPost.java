import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import MinStack.Pair;

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
public class PreInPost {
    public static List<List<Integer>> preInPostOrder(TreeNode root){
        if(root==null)  return new ArrayList<>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        Stack<Pair<TreeNode,Integer>> st=new Stack<>();
        
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair<TreeNode,Integer> it=st.pop();

            if(it.getValue()==1){
                pre.add(it.getKey().val);
                it.setValue(2);
                st.push(it);
                if(it.getKey().left!=null){
                    st.push(new Pair<>(it.getKey().left,1));
                }
            }
            else if(it.getValue()==2){
                in.add(it.getKey().val);
                it.setValue(3);
                st.push(it);
                if(it.getKey().right!=null){
                    st.push(new Pair<>(it.getKey().right,1));
                }
            }
            else{
                post.add(it.getKey().val);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;
    }
}
