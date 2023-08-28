public class T1446_maxPower {
    public int maxPower(String s) {
        int maxLen = 0;
        int len = 1;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                len++;
            }else{
                maxLen = Math.max(len, maxLen);
                len = 1;
            }
        }
        maxLen = Math.max(len, maxLen);
        return maxLen;
    }
}
