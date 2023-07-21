public class T880_decodeAtIndex {
    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        char[] cl = S.toCharArray();
        for (int i = 0; i < cl.length; i++) {
            if (Character.isLetter(cl[i]))
                size += 1;
            else size *= (int) cl[i]-48;
        }
        for (int j=cl.length-1;j>=0;j--){
            K%=size;
            if(K==0 && Character.isLetter(cl[j]))
                return  String.valueOf(cl[j]);
            if(Character.isLetter(cl[j]))size--;
            else size/=(int)cl[j]-48;
        }
        return null;
    }
}
