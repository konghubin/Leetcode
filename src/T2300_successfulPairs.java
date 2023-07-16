import java.util.Arrays;

public class T2300_successfulPairs {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for(int num = 0; num < spells.length; num++){
            int spell = spells[num];
            int i = 0;
            int j = potions.length;
            while(i < j){
                int mid = (i + j) / 2;
                if((long)spell * (long)potions[mid] >= success){
                    j = mid;
                }else{
                    i = mid + 1;
                }
            }
            res[num] = potions.length - i;
        }
        return res;
    }
}
