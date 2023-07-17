public class T343_integerBreak {
    Integer[] meno;
    public int integerBreak(int n) {
        if(n == 2){
            return 1;
        }
        meno = new Integer[n + 1];
        return dfs(n);
    }

    private int dfs(int n){
        if(n == 2 || n == 1){
            return n;
        }
        if(meno[n] != null){
            return meno[n];
        }
        int max = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(max, Math.max(dfs(i), i) * (n - i));
        }
        meno[n] = max;
        return meno[n];
    }
}
