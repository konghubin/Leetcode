import java.util.*;

public class T40_combinationSum2 {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> local = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        dfs(candidates, target, 0);
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }

    private void dfs(int[] candidates, int target, int index){
        if(target == 0){
            List<Integer> list = new ArrayList<>(local);
            list.sort(null);
            if(set.contains(list)){
                return;
            }else{
                set.add(list);
                res.add(local);
            }
        }
        if(index >= candidates.length){
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target) break;
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            local.add(candidates[i]);
            Exchange(candidates, index, i);
            dfs(candidates, target - candidates[index], index + 1);
            Exchange(candidates, index, i);
            local.remove(local.size() - 1);
        }
    }

    private void Exchange(int[] candidates, int i, int j){
        if(i == j){
            return;
        }else{
            int data = candidates[i];
            candidates[i] = candidates[j];
            candidates[j] = data;
        }
    }
}
