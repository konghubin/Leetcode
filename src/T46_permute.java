import java.util.*;

public class T46_permute {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> local = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int k){
        if(k >= nums.length){
            List<Integer> localList = new ArrayList<>(local);
            res.add(localList);
        }

        for(int i = k; i < nums.length; i++){
            local.add(nums[i]);
            change(nums, k, i);
            dfs(nums, k + 1);
            change(nums, k, i);
            local.remove(local.size() - 1);
        }
    }

    private void change(int[] nums, int i, int j){
        if(i != j){
            int data = nums[i];
            nums[i] = nums[j];
            nums[j] = data;
        }
    }
}
