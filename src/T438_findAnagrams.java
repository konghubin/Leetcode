import java.util.*;

public class T438_findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()){
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for(int i = 0; i < p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            windowMap.put(s.charAt(i), windowMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        if(verify(map, windowMap)){
            res.add(0);
        }
        int left = 1;
        int right = left + p.length() - 1;
        while(right < s.length()){
            windowMap.put(s.charAt(right), windowMap.getOrDefault(s.charAt(right), 0) + 1);
            windowMap.put(s.charAt(left - 1), windowMap.getOrDefault(s.charAt(left - 1), 0) - 1);
            if(windowMap.get(s.charAt(left - 1)) == 0){
                windowMap.remove(windowMap.get(s.charAt(left - 1)));
            }
            if(verify(map, windowMap)){
                res.add(left);
            }
            left++;
            right++;
        }
        return res;
    }

    private boolean verify(Map<Character, Integer> map, Map<Character, Integer> windowMap){
        for(char key : windowMap.keySet()){
            if(!windowMap.getOrDefault(key, 0).equals(map.getOrDefault(key, 0))){
                return false;
            }
        }
        return true;
    }
}
