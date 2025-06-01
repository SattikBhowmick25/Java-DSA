
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

public class TopView{
    public List<Integer> topView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<Integer,Integer> mpp=new TreeMap<>();

        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();

        q.add(new Pair<>(root,0));

        while(!q.isEmpty()){
            Pair<TreeNode,Integer> pair=q.poll();
            TreeNode node=pair.getKey();
            int line=pair.getValue();

            if(!mpp.containsKey(line)){
                mpp.put(line,node.val);
            }

            if(node.left!=null){
                q.add(new Pair<>(node.left,line-1));
            }
            if(node.right!=null){
                q.add(new Pair<>(node.right,line+1));
            }
        }

        for(int value:mpp.values()){
            ans.add(value);
        }

        return ans;
    }   
}