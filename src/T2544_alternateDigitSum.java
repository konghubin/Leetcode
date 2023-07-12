public class T2544_alternateDigitSum {
    public int alternateDigitSum(int n) {
        int res = 0;
        int flag = -1;
        while(n != 0){
            int num = n % 10;
            res += flag * num;
            n = n / 10;
            flag = - flag;
        }
        if(flag == 1){
            res = -res;
        }
        return res;
    }
}
