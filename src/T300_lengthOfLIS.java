public class T300_lengthOfLIS {
    Integer[] meno;
    int res = 1;
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        meno = new Integer[length];
        dfs(nums, length - 1);
        return res;
    }

    private int dfs(int[] nums, int n){
        if(n == 0){
            return 1;
        }
        if(meno[n] != null){
            return meno[n];
        }
        int max = 1;
        for(int i = 0; i < n; i++){
            if(nums[n] > nums[i]){
                max = Math.max(max, dfs(nums, i) + 1);
            }else{
                dfs(nums, i);
            }
        }
        meno[n] = max;
        if(meno[n] > res){
            res = meno[n];
        }
        return meno[n];
    }
}
