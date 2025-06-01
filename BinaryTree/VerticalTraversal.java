import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Pair;

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

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    // Map: vertical -> level -> list of node values
    Map<Integer, Map<Integer, List<Integer>>> nodes = new TreeMap<>();

    Queue<Pair<TreeNode, Pair<Integer, Integer>>> todo = new LinkedList<>();
    todo.add(new Pair<>(root, new Pair<>(0, 0)));

    while (!todo.isEmpty()) {
        Pair<TreeNode, Pair<Integer, Integer>> p = todo.poll();
        TreeNode temp = p.getKey();
        int x = p.getValue().getKey();
        int y = p.getValue().getValue();

        nodes.computeIfAbsent(x, k -> new TreeMap<>())
             .computeIfAbsent(y, k -> new ArrayList<>())
             .add(temp.val);

        if (temp.left != null) {
            todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
        }
        if (temp.right != null) {
            todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
        }
    }

    List<List<Integer>> ans = new ArrayList<>();
    for (Map<Integer, List<Integer>> ys : nodes.values()) {
        List<Integer> col = new ArrayList<>();
        for (List<Integer> list : ys.values()) {
            Collections.sort(list);  // To match the problem's requirement: sort nodes at same (x, y)
            col.addAll(list);
        }
        ans.add(col);
    }

    return ans;
    }

}
