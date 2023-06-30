public class T2490_isCircularSentence {
    public boolean isCircularSentence(String sentence) {
        int length = sentence.length();
        if(sentence.charAt(0) != sentence.charAt(length - 1)){
            return false;
        }
        for(int i = 0; i < length; i++){
            if(sentence.charAt(i) == ' '){
                if(sentence.charAt(i - 1) != sentence.charAt(i + 1)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean titleIsCircularSentence(String sentence) {
        int len = sentence.length();
        char[] sc = sentence.toCharArray();
        if(sc[0] != sc[len-1]) {
            return false;
        }
        for(int i=0;i<sc.length;i++) {
            if(sc[i]==' ' && sc[i-1]!=sc[i+1]) {
                return false;
            }
        }
        return true;
    }
}
