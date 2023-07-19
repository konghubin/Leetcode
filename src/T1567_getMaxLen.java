public class T1567_getMaxLen {
    public int getMaxLen(int[] nums) {
        int res = 0;
        int left = 0;
        int right = 0;
        int neg = 0;
        while(right < nums.length && nums[right] == 0){
            right++;
        }
        left = right;
        while(right < nums.length){
            if(nums[right] != 0){
                if(nums[right] < 0){
                    neg++;
                }
                if(neg % 2 == 0){
                    res = Math.max(res,right - left + 1);
                }
                right++;
            }else{
                while(left < right){
                    if(nums[left] < 0){
                        neg--;
                    }
                    left++;
                    if(neg % 2 == 0){
                        res = Math.max(res,right - left);
                    }
                }
                while(right < nums.length && nums[right] == 0){
                    right++;
                }
                left = right;
                neg = 0;
            }
        }
        while(left < right){
            if(nums[left] < 0){
                neg--;
            }
            left++;
            if(neg % 2 == 0){
                res = Math.max(res,right - left);
            }
        }
        return res;
    }
}
