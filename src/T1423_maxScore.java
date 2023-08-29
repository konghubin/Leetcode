public class T1423_maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int min = 0;
        int loaclMin = 0;
        int sum = 0;
        int len = cardPoints.length;
        int m = len - k;

        for(int i = 0; i < m; i++){
            loaclMin += cardPoints[i];
            sum += cardPoints[i];
        }
        min = loaclMin;

        int start = m;
        while(start <cardPoints.length){
            loaclMin += cardPoints[start] - cardPoints[start - m];
            min = Math.min(min, loaclMin);
            sum += cardPoints[start];
            start++;
        }

        return sum - min;
    }
}
