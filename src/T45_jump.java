public class T45_jump {
    Integer[] meno;
    public int jump(int[] nums) {
        int n = nums.length;
        meno = new Integer[n];
        return dfs(nums, n - 1);
    }

    public int dfs(int[] nums, int n){
        if(n == 0){
            return 0;
        }

        if(meno[n] != null){
            return meno[n];
        }

        int minJump = 0 / 0;
        for(int i = 0; i < n; i++){
            if(i + nums[i] >= n && dfs(nums, i) < minJump){
                minJump = dfs(nums, i);
            }
        }
        meno[n] = minJump + 1;
        return meno[n];
    }

    //----------------------------------------------------------
    public int titleJump(int[] nums) {

        int n = nums.length;
        if(n == 1){
            return 0;
        }

        int step = 1;

        int start = 0;
        int end = nums[0];

        while(end < n-1){
            step++;
            int target = getTarget(nums, start, Math.min(n-1, end));
            start = target;
            end = start+nums[start];
        }

        return step;
    }

    public int getTarget(int[] nums, int start, int end){

        int index = 0;
        int max = 0;

        for (int i = start+1; i <= end; i++) {
            if(nums[i]+i > max){
                index = i;
                max = nums[i]+i;
            }
        }

        return index;
    }
}
