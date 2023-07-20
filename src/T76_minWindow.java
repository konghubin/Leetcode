import java.util.*;

public class T76_minWindow {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int resLeft = Integer.MIN_VALUE / 3;
        int resRight = Integer.MAX_VALUE / 3; 
        int left = 0;
        int right = 0;
        while(right < s.length()){
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            if(check(tMap, sMap)){
                while(left <= right && check(tMap, sMap)){
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                    left++;
                }
                if(right - left + 1 <= resRight - resLeft){
                    resLeft = left - 1;
                    resRight = right;
                }
            }
            right++;
        }
        if(resLeft == Integer.MIN_VALUE / 3){
            return "";
        }
        return s.substring(resLeft, resRight + 1);
    }

    private boolean check(Map<Character, Integer> tMap, Map<Character, Integer> sMap){
        for(Character key : tMap.keySet()){
            int value = tMap.getOrDefault(key, 0);
            if(value > sMap.getOrDefault(key, 0)){
                return false;
            }
        }
        return true;
    }
}
