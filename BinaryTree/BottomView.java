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
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
public class BottomView {
    public List<Integer> bottomView(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair<TreeNode,Integer>> q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        while(!q.isEmpty()){
            Pair<TreeNode,Integer> pair=q.poll();
            TreeNode node=pair.getKey();
            int line=pair.getValue();

            map.put(line,node.val);
            if(node.left!=null){
                q.add(new Pair<>(root.left,line-1));
            }
            if(node.right!=null){
                q.add(new Pair<>(root.right,line+1));
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
