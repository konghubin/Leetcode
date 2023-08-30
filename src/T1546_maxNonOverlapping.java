import java.util.*;

public class T1546_maxNonOverlapping {
    public int maxNonOverlapping(int[] nums, int target) {
        int res = 0;
        int i = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        while(i < nums.length){
            sum += nums[i];
            if(set.contains(sum - target)){
                set.clear();
                set.add(0);
                sum = 0;
                res++;
            }else{
                set.add(sum);
            }
            i++;
        }
        return res;
    }
}
