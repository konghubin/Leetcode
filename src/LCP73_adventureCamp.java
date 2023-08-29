import java.util.*;

public class LCP73_adventureCamp {
    public int adventureCamp(String[] expeditions) {
        Set<String> set = new HashSet<>();
        int res = 0;
        int num = 0;
        if(!expeditions[0].equals("")){
            String[] initCamps = expeditions[0].split("->");
            for(int i = 0; i < initCamps.length; i++){
                set.add(initCamps[i]);
            }
        }
        for(int i = 1; i < expeditions.length; i++){
            int localNum = 0;
            if(!expeditions[i].equals("")){
                String[] camps = expeditions[i].split("->");
                for(String camp : camps){
                    if(!set.contains(camp)){
                        localNum++;
                        set.add(camp);
                    }
                }
                if(num < localNum){
                    res = i;
                    num = localNum;
                }
            }
        }
        return num > 0 ? res : -1;
    }
}
