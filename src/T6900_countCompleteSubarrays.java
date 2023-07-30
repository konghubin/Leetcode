import java.util.*;

public class T6900_countCompleteSubarrays {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            numsSet.add(nums[i]);
        }
        int difNum = numsSet.size();
        int left = 0;
        int right = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if(map.size() == difNum){
                res += nums.length - right;
                while(map.size() == difNum){
                    map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                    if(map.get(nums[left]) <= 0){
                        map.remove(nums[left]);
                    }else{
                        res += nums.length - right;
                    }
                    left++;
                }
            }
            right++;
        }
        return res;
    }
}
