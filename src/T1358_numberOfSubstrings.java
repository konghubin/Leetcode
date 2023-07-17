public class T1358_numberOfSubstrings {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int left = 0;
        int right = 0;
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        while(right < s.length()){
            if(s.charAt(right) == 'a'){
                aNum++;
            }
            if(s.charAt(right) == 'b'){
                bNum++;
            }
            if(s.charAt(right) == 'c'){
                cNum++;
            }
            if(aNum != 0 && bNum != 0 && cNum != 0){
                res += s.length() - right;
                if(s.charAt(left) == 'a'){
                    aNum--;
                }
                if(s.charAt(left) == 'b'){
                    bNum--;
                }
                if(s.charAt(left) == 'c'){
                    cNum--;
                }
                left++;
                while(aNum != 0 && bNum != 0 && cNum != 0){
                    if(s.charAt(left) == 'a'){
                        aNum--;
                    }
                    if(s.charAt(left) == 'b'){
                        bNum--;
                    }
                    if(s.charAt(left) == 'c'){
                        cNum--;
                    }
                    left++;
                    res += s.length() - right;
                }
            }
            right++;
        }
        return res;
    }
}
