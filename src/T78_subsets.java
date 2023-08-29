import java.util.*;

public class T78_subsets {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return res;
    }

    private void dfs(int index, int[] nums){
        if(index >= nums.length){
            List<Integer> resList = new ArrayList<>(list);
            res.add(resList);
            return;
        }
        dfs(index + 1, nums);
        list.add(nums[index]);
        dfs(index + 1, nums);
        list.remove(list.size() - 1);
    }
}
