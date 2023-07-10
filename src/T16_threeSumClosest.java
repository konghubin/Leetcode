import java.util.Arrays;

public class T16_threeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int n = nums.length - 1;
            while(j < n){
                int sum = nums[i] + nums[j] + nums[n];
                if(sum == target){
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum > target){
                    n--;
                }else{
                    j++;
                }
            }
        }
        return res;
    }
}
