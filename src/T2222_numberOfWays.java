public class T2222_numberOfWays {
    public long numberOfWays(String s) {
        int[] leftZero = new int[s.length()];
        int[] rightZero = new int[s.length()];
        int[] leftOne = new int[s.length()];
        int[] rightOne = new int[s.length()];
        int leftOneNum = 0;
        int leftZeroNum= 0;
        int rightOneNum = 0;
        int rightZeroNum = 0;
        long res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                leftOne[i] = leftOneNum;
                leftZero[i] = 0;
                leftZeroNum++;
            }else{
                leftZero[i] = leftZeroNum;
                leftOne[i] = 0;
                leftOneNum++;
            }
        }
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                rightOne[i] = rightOneNum;
                rightZero[i] = 0;
                rightZeroNum++;
            }else{
                rightZero[i] = rightZeroNum;
                rightOne[i] = 0;
                rightOneNum++;
            }
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                res += leftOne[i] * rightOne[i];
            }else{
                res += leftZero[i] * rightZero[i];
            }
        }
        return res;
    }
}
