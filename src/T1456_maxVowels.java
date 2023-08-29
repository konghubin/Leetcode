import java.util.HashSet;
import java.util.Set;

public class T1456_maxVowels {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        int local = 0;
        for(int i = 0; i < k; i++){
            if(set.contains(s.charAt(i))){
                local++;
            }
        }
        res = local;
        int start = k;
        while(start < s.length()){
            if(set.contains(s.charAt(start))){
                local++;
            }
            if(set.contains(s.charAt(start - k))){
                local--;
            }
            res = Math.max(res, local);
            start++;
        }
        return res;
    }
}
