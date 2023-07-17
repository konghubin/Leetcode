public class T2024_maxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int left = 0;
        int right = 0;
        char[] keys = answerKey.toCharArray();
        int kFlag = 0;
        int res = 0;
        while(right < keys.length){
            if(keys[right] == 'T'){
                res = Math.max(res, right - left + 1);
                right++;
            }else{
                if(kFlag < k){
                    kFlag++;
                    res = Math.max(res, right - left + 1);
                }else{
                    while(keys[left] != 'F'){
                        left++;
                    }
                    left++;
                }
                right++;
            }
        }
        kFlag = 0;
        left = 0;
        right = 0;
        while(right < keys.length){
            if(keys[right] == 'F'){
                res = Math.max(res, right - left + 1);
                right++;
            }else{
                if(kFlag < k){
                    kFlag++;
                    res = Math.max(res, right - left + 1);
                }else{
                    while(keys[left] != 'T'){
                        left++;
                    }
                    left++;
                }
                right++;
            }
        }
        return res;
    }
}
