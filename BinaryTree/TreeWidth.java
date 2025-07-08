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

class Pair<K,V>{
    K key;
    V value;
    Pair(K key,V value){
        this.key=key;
        this.value=value;
    }
}

public class TreeWidth{
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)  return 0;
        int width=0;

        Queue<Pair<TreeNode,Integer>>  q=new LinkedList<>();
        q.add(new Pair<>(root,0));

        while(!q.isEmpty()){

            int levelMin=q.peek().value;
            int size=q.size();
            int first=0,last=0;

            for(int i=0;i<size;i++){

                int curIdx=q.peek().value-levelMin;
                TreeNode node=q.peek().key;
                q.poll();

                if(i==0)        first=curIdx;
                if(i==size-1)   last=curIdx;
                if(node.left!=null){
                    q.add(new Pair<>(node.left,curIdx*2+1));
                }
                if(node.right!=null){
                    q.add(new Pair<>(node.right,curIdx*2+2));
                }
            }
            width=Math.max(width,last-first+1);
        }
        return width;
    }
}