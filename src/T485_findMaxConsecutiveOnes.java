public class T485_findMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;
        while(right < nums.length){
            if(nums[right] == 1){
                res = Math.max(res, right - left + 1);
            }else{
                left = right + 1;
                while(nums[left] == 0 && left < nums.length){
                    left++;
                }
            }
            right++;
        }
        return res;
    }
}
