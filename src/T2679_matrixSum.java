import java.util.*;

public class T2679_matrixSum {
    public int matrixSum(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            Arrays.sort(nums[i]);
        }
        for(int i = n - 1; i >= 0; i--){
            int max = 0;
            for(int j = 0; j < m; j++){
                if(nums[j][i] > max){
                    max = nums[j][i];
                }
            }
            res += max;
        } 
        return res;
    }

    //-----------------------------------------------
    public static int titleMatrixSum(int[][] nums) {
    	int N = nums[0].length;
    	int[] maxs = new int[N];
    	int[] map = new int[1020];
    	for(int[] ar : nums) {
    		int maxv = 0;
    		for(int v : ar) {
    			maxv = Math.max(maxv,v);
    			map[v] ++;
    		}
    		int n = N;
    		int minv = maxs[0];
    		for(int v=maxv; v>minv && n>0; v--) {
    			int c = map[v];
    			if(c == 0) continue;
    			map[v] = 0;
    			for(;c!=0;c--) {
    				if(maxs[--n] < v)
    					maxs[n] = v;
    			}
    		}
    	}
    	int res = 0;
    	for(int v : maxs) 
    		res += v;
    	return res;
    }

}
