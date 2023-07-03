public class T198_rob {
    Integer[] meno;
    public int rob(int[] nums) {
        int length = nums.length;
        meno = new Integer[length];
        return dfs(nums, length - 1);
    }
    public int dfs(int[] nums, int n){
        if(n < 0){
            return 0;
        }
        if(meno[n] != null){
            return meno[n];
        }
        meno[n] = Math.max(dfs(nums, n - 2) + nums[n], dfs(nums, n - 1));
        return meno[n];
    }

    //------------------------------------------------------------------------
    public int titleRob(int[] nums) {
        int n=nums.length;

        int[] res=new int[n];
        int max=res[0]=nums[0];
        if(n>1) {res[1]=Math.max(nums[0], nums[1]);max=res[1];}
        for(int i=2;i<n;++i)
        {
            res[i]=Math.max(res[i-1], res[i-2]+nums[i]);
            max=Math.max(max, res[i]);
        }

        return res[n-1];

    }
}
