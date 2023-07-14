import java.util.*;

public class T970_powerfulIntegers {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 21; i++){
            for(int j = 0; j < 21; j++){
                int local = (int)Math.pow(x, i) + (int)Math.pow(y, j);
                if(local <= bound){
                    set.add(local);
                }else{
                    break;
                }
                if(y == 1){
                    break;
                }
            }
            if((int)Math.pow(x, i) + (int)Math.pow(y, 0) > bound){
                break;
            }
            if(x == 1){
                break;
            }
        }
        return new ArrayList<>(set);
    }
}
