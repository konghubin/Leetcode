public class T1578_minCost {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        int index = 0;
        while(index < colors.length() - 1){
            if(colors.charAt(index) == colors.charAt(index + 1)){
                int min = Math.min(neededTime[index], neededTime[index + 1]);
                int max = Math.max(neededTime[index], neededTime[index + 1]);
                neededTime[index + 1] = max;
                res += min;
            }
            index++;
        }
        return res;
    }
}
