import java.util.Arrays;

public class T2767_minimumBeautifulSubstrings {
    public int minimumBeautifulSubstrings(String s) {
        if(s.substring(0, 1).equals("0")){
            return -1;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, s.length() + 1);
        if(Check(s.substring(0, 1))){
            dp[0] = 1;
        }
        for(int i = 1; i < s.length();i++){
            int min = s.length() + 1;
            if(Check(s.substring(0, i+1))){
                min = 1;
            }
            for(int j = 0; j < i; j++){
                if(s.substring(j + 1, j + 2).equals("0")){
                    continue;
                }
                if(Check(s.substring(j + 1, i + 1)) && dp[j] != s.length() + 1){
                    min = Math.min(min, dp[j] + 1);
                }
            }
            dp[i] = min;
        }
        if(dp[s.length() - 1] == s.length() + 1){
            return -1;
        }
        return dp[s.length() - 1];
    }

    private boolean Check(String sub){
        int sum = 0;
        int k = 1;
        for(int i = sub.length() - 1; i >= 0; i--){
            int data = Integer.valueOf(sub.substring(i, i + 1));
            sum += k * data;
            k *= 2;
        }
        while(sum / 5 != 0){
            if(sum % 5 != 0){
                return false;
            }else{
                sum /= 5;
            }
        }
        if(sum == 1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        T2767_minimumBeautifulSubstrings test = new T2767_minimumBeautifulSubstrings();
        String s = "1011";
        test.minimumBeautifulSubstrings(s);
        System.out.println(test.Check("1011"));
    }
}
