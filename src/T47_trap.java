public class T47_trap {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxL = height[left], maxR = height[right];
        int res = 0;
        while (left < right) {
            maxL = Math.max(maxL, height[left]);
            maxR = Math.max(maxR, height[right]);
            res += maxR > maxL ? maxL - height[left++] : maxR - height[right--];
        }
        return res;
    }
    //---------------------------------------------------------------------------------------
    public static int titleTrap(int[] height) {
        int res = 0, l = 0, n = height.length, r = n - 1, pre_max = 0, suf_max = 0;
        while(l <= r){
            pre_max = Math.max(pre_max, height[l]);
            suf_max = Math.max(suf_max, height[r]);
            if(pre_max < suf_max){
                res += pre_max - height[l++];
            } else {
                res += suf_max - height[r--];
            }
        }
        return res;
    }
}
