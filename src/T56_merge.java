import java.util.*;;

public class T56_merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
    //--------------------------------------------------------------------------------------------------
    public int[][] tirleMerge(int[][] intervals) {
        int max = -1;
        int min = 100000;
        for(int[] i:intervals){
            if(max<i[1])
                max = i[1];
            if(min>i[0])
                min = i[0];
        }
        int len = max - min +1;
        int[] pos = new int[len];
        for(int[] tuple:intervals){
            int index = tuple[0]-min;
            if(pos[index]>0){
                if(pos[index]<tuple[1]-min)
                    pos[index]=tuple[1]-min;
            }else{
                pos[index]=tuple[1]-min;
            }
        }
        int start = 0;
        int end = pos[0];
        ArrayList<int[]> rsult=new ArrayList<>(intervals.length >> 1);
        for(int i=1;i<len;i++){
            if(pos[i]!=0){
                if(i<=end){
                    end = Math.max(end,pos[i]);
                }else{
                    rsult.add(new int[]{start+min,end+min});
                    start = i;
                    end = pos[i];
                }
            }
        }
        rsult.add(new int[]{start+min,end+min});
        return rsult.toArray(new int[][]{});

    }
}
