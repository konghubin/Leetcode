public class T26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        for(int j = 1; j < nums.length; j++){
            if(nums[j] != nums[j - 1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    //--------------------------------------------------
    public int titleRemoveDuplicates(int[] nums) {   
        return process(nums, 1);
        }
        int process(int[] nums, int k) {
            int u = 0; 
            for (int x : nums) {
                if (u < k || nums[u - k] != x) nums[u++] = x;
            }
            return u;
        }
}
