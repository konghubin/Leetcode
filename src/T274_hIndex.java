import java.util.Arrays;

public class T274_hIndex {
    public int hIndex(int[] citations) {
        int res = 0;
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >= 0; i--){
            int num = citations.length - i;
            int score = citations[i];
            if(num >= score){
                res = Math.max(score, res);
            }else{
                res = Math.max(num, res);
            }
        }
        return res;
    }
}
