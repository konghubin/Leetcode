import java.util.*;

public class T77_combine {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        DFS(n, k , 1);
        return res;
    }

    private void DFS(int n, int k, int index){
        if(list.size() == k){
            List<Integer> newList = new ArrayList<>(list);
            res.add(newList);
            return;
        }
        if(index > n){
            return;
        }
        DFS(n, k, index + 1);
        list.add(index);
        DFS(n, k, index + 1);
        list.remove(list.size() - 1);
    }

    //---------------------------------------------------------------
    private List<Integer>[] combinationList;
    private int pos;
    private int[] combination;

    public List<List<Integer>> titleCombine(int n, int k) {
        combinationList = new List[getCombine(n, k)];
        combination = new int[k];
        backtracking(n, 1, k, 0);
        return Arrays.asList(combinationList);
    }

    // 从 num 开始选择数字，填放 combination 数组的 idx 位置。
    private void backtracking(int n, int num, int k, int idx) {
        if (n - num + 1 < k - idx) {
            return; // 剩余可选择的元素 < 需要的元素。
        }
        if (idx < k) {
            backtracking(n, num + 1, k, idx);
            combination[idx] = num;
            backtracking(n, num + 1, k, idx + 1);
        } else {
            Integer[] newCombination = new Integer[k];
            for (int i = 0; i < k; i++) {
                newCombination[i] = combination[i];
            }
            combinationList[pos++] = Arrays.asList(newCombination);
        }
    }

    // 计算 C(n, k) 的组合数。
    private int getCombine(int n, int k) {
        long x = 1, y = 1;
        for (int i = 1; i <= k; i++) {
            y *= i;
            x *= n - i + 1;
        }
        return (int) (x / y);
    }
}
