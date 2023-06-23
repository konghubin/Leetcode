public class T2496_maximumValue {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            int sLen = s.length();
            boolean flag = false;
            for(int j = 0; j < sLen; j++){
                if(!Character.isDigit(s.charAt(j))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                res = Math.max(res, sLen);
            }else{
                res = Math.max(res, Integer.parseInt(s));
            }
        }
        return res;
    }
    //---------------------------------------------------------
    public int titleMaximumValue(String[] strs) {
        int max = 0;
        int cur = 0;
        for(String s:strs) {
            for(int i = 0; i < s.length(); ++i) {
                char c = s.charAt(i);
                if(!Character.isDigit(c)) {
                    cur = s.length();
                    break;
                }
                else {
                    cur = cur * 10 + c - '0';
                }
            }
            max = Math.max(max, cur);
            cur = 0;
        }
        return max;
    }
}
