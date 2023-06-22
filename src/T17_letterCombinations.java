import java.util.*;

public class T17_letterCombinations {
    final char[][] numberMap = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, 
{'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        StringBuilder builder = new StringBuilder();
        int index = 0;
        DFS(res, digits, index, builder);
        return res; 
    }

    private void DFS(List<String> res, String digits, int index, StringBuilder builder){
        int length = digits.length();
        if(index == length){
            String s = builder.toString();
            res.add(s);
            return;
        }
        char[] charArray = numberMap[Integer.parseInt(String.valueOf(digits.charAt(index))) - 2];
        for(int i = 0; i < charArray.length; i++){
            builder.append(charArray[i]);
            DFS(res, digits, index + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    //------------------------------------------------------------------------------------------------
    //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
    String[] nums = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //设置全局列表存储最后的结果
    List<String> result = new ArrayList<>();
    //每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
    StringBuilder stringBuilder = new StringBuilder();

    public List<String> titleLetterCombinations(String digits) {
        if (digits==null||digits.length()==0){
            return result;
        }
        rollBack(digits,0);

        return result;
    }
    //比如digits如果为"23",index 为0，则str表示2对应的 abc
    void rollBack(String digits,int index){
    //遍历全部一次记录一次得到的字符串
        if (digits.length()==index){
            result.add(stringBuilder.toString());
            return;
        }
        String str = nums[digits.charAt(index)-'0'];
        for(int i = 0 ;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
            rollBack(digits,index+1);
            //剔除末尾的继续尝试
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
