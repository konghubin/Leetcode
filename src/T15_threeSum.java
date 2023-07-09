import java.util.*;;

public class T15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int n = nums.length - 1;
            while(j < n){
                int sum = nums[i] + nums[j] + nums[n];
                if(sum < 0){
                    while(j < n && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                }else if(sum > 0){
                    while(j < n && nums[n] == nums[n - 1]){
                        n--;
                    }
                    n--;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[n]);
                    res.add(list);
                    while(j < n && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                    while(j < n && nums[n] == nums[n - 1]){
                        n--;
                    }
                    n--;
                }
            }
        }
        return res;
    }
}
