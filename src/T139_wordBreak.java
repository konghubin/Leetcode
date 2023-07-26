import java.util.*;

public class T139_wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[0] && wordSet.contains(s.substring(j, i))){
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
