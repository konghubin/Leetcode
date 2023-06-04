public class t12_Rome {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int[] dataArray = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romeAarray = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for(int i = dataArray.length-1;i >= 0; i--){
            int romeNum = num / dataArray[i];
            num = num - romeNum * dataArray[i];
            for(int j=0;j < romeNum;j++){
                builder.append(romeAarray[i]);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        t12_Rome test = new t12_Rome();
        System.out.println(test.intToRoman(1994)); 
    }
}
