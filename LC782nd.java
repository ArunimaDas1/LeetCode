import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Crucial: sort to bring duplicates adjacent
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            
           

            current.add(nums[i]);                  // Choose
            backtrack(i + 1, nums, current, result); // Explore
            current.remove(current.size() - 1);    // Undo (Backtrack)
        }
    }
}public class LC782nd {

}
