import java.util.ArrayDeque;
import java.util.Deque;

public class T1306_canReach {
    public boolean canReach(int[] arr, int start) {
        if(arr[start] == 0){
            return true;
        }
        boolean[] flag = new boolean[arr.length];
        Deque<Integer> queue = new ArrayDeque<>();
        flag[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int node = queue.poll();
                if(arr[node] == 0){
                    return true;
                }
                if(node + arr[node] >= 0 && node + arr[node] < arr.length && !flag[node + arr[node]]){
                    queue.offer(node + arr[node]);
                    flag[node + arr[node]] = true;
                }
                if(node - arr[node] >= 0 && node - arr[node] < arr.length && !flag[node - arr[node]]){
                    queue.offer(node - arr[node]);
                    flag[node - arr[node]] = true;
                }
            }
        }
        return false;
    }
}
