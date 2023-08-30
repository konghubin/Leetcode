import java.util.*;

public class T1481_findLeastNumOfUniqueInts {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int[] keyValue = {entry.getKey(), entry.getValue()};
            list.add(keyValue);
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] keyValue1, int[] keyValue2){
                return keyValue1[1] - keyValue2[1];
            }
        });

        int res = list.size();
        for(int i = 0; i < list.size(); i++){
            int value = list.get(i)[1];
            if(k >= value){
                res--;
                k -= value;
            }else{
                break;
            }
        }
        return res;
    }
}
