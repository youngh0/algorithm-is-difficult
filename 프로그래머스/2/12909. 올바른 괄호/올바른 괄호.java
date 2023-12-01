
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        char[] sequence = s.toCharArray();
        for (char c : sequence) {
            if (c == '(') {
                dq.offerLast(c);
                continue;
            }
            if (dq.isEmpty()) {
                return false;
            }
            if (dq.peek() != '(') {
                return false;
            }
            dq.pollLast();
        }
        return dq.isEmpty();
    }
}
