public class t11_water {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while(i < j){
            int area = (j - i) * Math.min(height[i], height[j]);
            if(area > max){
                max = area;
            }
            if(height[i] <= height[j]){
                i++;
            }else{
                j--;
            }
            
        }
        return max;
    }
    public int bestMaxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            int minH = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            // 快速跳过这步可太妙了
            while (height[l] <= minH && l < r) {
                l++;
            }
            while (height[r] <= minH && l < r) {
                r--;
            }
        }
        return maxArea;
    }
}
