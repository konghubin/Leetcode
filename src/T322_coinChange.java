public class T322_coinChange {
    Integer[] meno;
    public int coinChange(int[] coins, int amount) {
        meno = new Integer[amount + 1];
        return dfs(coins, amount);
    }

    public int dfs(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(meno[amount] != null){
            return meno[amount];
        }
        int min = Integer.MAX_VALUE / 2;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] > amount){
                continue;
            }
            int data = dfs(coins, amount - coins[i]);
            if(data == -1){
                continue;
            }else{
                min = Math.min(min, dfs(coins, amount - coins[i]) + 1);
            }
        }
        if(min == Integer.MAX_VALUE / 2){
            min = -1;
        }
        meno[amount] = min;
        return meno[amount];
    }
}
