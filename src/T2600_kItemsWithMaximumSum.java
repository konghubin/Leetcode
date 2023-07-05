public class T2600_kItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(k <= numOnes){
            return k;
        }else if(k > numOnes && k <= numOnes + numZeros){
            return numOnes;
        }else{
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
