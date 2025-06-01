import java.util.ArrayList;
import java.util.List;

public class SubsetSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, 0, k, n, new ArrayList<>(), res);
        return res;
    }
    
    private void backtrack(int start, int sum, int k, int n, List<Integer> current, List<List<Integer>> res) {
        if (current.size() == k) {
            if (sum==n) {
                res.add(new ArrayList<>(current)); // Make a copy of current
            }
            return;
        }
    
        for (int i = start; i <= 9; i++) {
            if (i > n) break; // Prune the recursion
            current.add(i);
            backtrack(i + 1, sum+i, k, n, current, res);
            current.remove(current.size() - 1); // Backtrack
        }
    }
}
