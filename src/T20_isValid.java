import java.util.*;

public class T20_isValid {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty() || s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else{
                char node = stack.pop();
                if((s.charAt(i) == '}' && node != '{') || (s.charAt(i) == ']' && node != '[') || (s.charAt(i) == ')' && node != '(')){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    //-------------------------------------------------------------------------------
    public boolean titleIsValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;//栈顶指针
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[++top] = ')';
            } else if (c == '[') {
                stack[++top] = ']';
            } else if (c == '{') {
                stack[++top] = '}';
            } else if (top == -1 || stack[top--] != c) {//之前没有对应的左括号或者左右括号不匹配
                return false;
            }
        }
        return top == -1;//判断是否有剩余的左括号没有被匹配
    }
}
