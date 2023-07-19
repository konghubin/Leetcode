public class T1004_longestOnes {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        int turnNum = 0;
        while(right < nums.length){
            if(nums[right] == 1 || turnNum < k){
                res = Math.max(res, right - left + 1);
                if(nums[right] == 0){
                    turnNum++;
                }
            }else{
                while(left <= right && nums[left] == 1){
                    left++;
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
