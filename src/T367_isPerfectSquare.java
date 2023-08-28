public class T367_isPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int i = 0;
        int j = num;
        while(i <= j){
            int mid = (i + j) / 2;
            long data = (long)mid * mid;
            if(data == num){
                return true;
            }
            if(data < num){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        return false;
    }
}
