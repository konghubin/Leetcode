import java.util.*;

public class T752_openLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        for(int i = 0; i < deadends.length; i++){
            set.add(deadends[i]);
        }
        if(set.contains(target) || set.contains("0000")){
            return -1;
        }
        if(target.equals("0000")){
            return 0;
        }
        int step = 0;
        queue.offer("0000");
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String local = queue.poll();
                for(int j = 0; j < 4; j++){
                    for(int k = -1; k <= 1; k = k + 2){
                        int num = Integer.parseInt(local.substring(j, j + 1));
                        num = num + k;
                        if(num == -1){
                            num = 9;
                        }
                        if(num == 10){
                            num = 0;
                        }
                        String newLocal = local.substring(0, j) + num + local.substring(j + 1, 4);
                        if(newLocal.equals(target)){
                            return step;
                        }
                        if(!visited.contains(newLocal) && !set.contains(newLocal)){
                            queue.add(newLocal);
                            visited.add(newLocal);
                        }
                    }
                }
            }
        }
        return -1;
        
    }

    public static void main(String[] args) {
        T752_openLock test = new T752_openLock();
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        test.openLock(deadends, "0202");
    }
}
