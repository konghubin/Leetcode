import java.util.*;

public class T2023_numOfPairs {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> mp = new HashMap<>();
        for (String s : nums) {
            mp.put(s, mp.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (int i = 1; i < target.length(); i++) {
            String subLeft = target.substring(0, i);
            String subRight = target.substring(i, target.length());
            if (!subLeft.equals(subRight)) {
                res += mp.getOrDefault(subLeft, 0) * mp.getOrDefault(subRight, 0);
            } else {
                res += mp.getOrDefault(subLeft, 0) * (mp.getOrDefault(subLeft, 0) - 1);
            }
        }
        return res;
    }
}
