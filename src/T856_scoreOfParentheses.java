import java.util.*;

public class T856_scoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Deque<Character> deque = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') deque.addLast('(');
            else {
                char c = deque.removeLast();
                if (c == '(') {
                    deque.addLast('1');
                } else {
                    int sum = c - '0';
                    while ((c = deque.removeLast()) != '(')  sum += c - '0';
                    deque.addLast((char) ((sum << 1) + '0'));
                }
            }
        }
        int result = 0;
        while (!deque.isEmpty()) result += deque.removeLast() - '0';
        return result;
    }
}
