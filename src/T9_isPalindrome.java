public class T9_isPalindrome {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }
        String s = Integer.toString(x);

        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    //--------------------------------------------------
    public boolean titleIsPalindrome(int x) {
        if(x<0||(x!=0&&x%10==0)){
            return false;
        }
        
        int num=0;
        while(x>num){
            num=num*10+x%10;
            x/=10;
        }
        if(x==num||x==num/10){
            return true;
        }
        return false;
    }
}
