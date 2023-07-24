public class T494_findTargetSumWays {
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target);
        return res;
    }

    private void dfs(int[] nums, int index, int target){
        if(index >= nums.length){
            if(target == 0){
                res += 1;
            }
            return;
        }
        int smallTarget = target - nums[index];
        dfs(nums, index + 1, smallTarget);
        int bigTarget = target + nums[index];
        dfs(nums, index + 1, bigTarget);
    }
}
