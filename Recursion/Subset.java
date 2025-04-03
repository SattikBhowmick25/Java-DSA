import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public void subsets(int[] nums, int ind, List<Integer> ds, List<List<Integer>> res) {
        if (ind == nums.length) {
            res.add(new ArrayList<>(ds)); // Create a new list to avoid mutation issues
            return;
        }
        // Include the current element
        ds.add(nums[ind]);
        subsets(nums, ind + 1, ds, res);
        ds.remove(ds.size() - 1);
        // Skip duplicate elements
        while (ind + 1 < nums.length && nums[ind] == nums[ind + 1]) {
            ind++;
        }
        // Exclude the current element
        subsets(nums, ind + 1, ds, res);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // Sort to handle duplicates
        List<List<Integer>> ans = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
}
