public class T58_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int res = 0;
        boolean flag = false;
        for(int i = s.length() - 1; i >= 0; i--){
            if(!flag && s.charAt(i) != ' '){
                flag = true;
            }
            if(flag){
                if(s.charAt(i) != ' '){
                    res++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    //--------------------------------------------------
    public int titleLengthOfLastWord(String s) {
        int index = s.length()-1;
        while(s.charAt(index) == ' '){
            index--;
        }
        int wordLength = 0;
        while(index>=0 && s.charAt(index) != ' '){
            wordLength++;
            index--;
        }
        return wordLength;
     }
}
