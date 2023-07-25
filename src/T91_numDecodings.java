public class T91_numDecodings {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++){
            int res = 0;
            if(s.charAt(i) == '0' && Integer.valueOf(s.substring(i - 1, i + 1)) > 26){
                dp[i] = 0;
                continue;
            }
            if(s.charAt(i) != '0'){
                res += dp[i - 1];
            }
            if(Integer.valueOf(s.substring(i - 1, i + 1)) <= 26 && Integer.valueOf(s.substring(i - 1, i + 1)) > 9){
                if(i > 1){
                    res += dp[i - 2];
                }
                else{
                    res += 1;
                }
            }
            dp[i] = res;
        }
        return dp[s.length() - 1];
    }
}
