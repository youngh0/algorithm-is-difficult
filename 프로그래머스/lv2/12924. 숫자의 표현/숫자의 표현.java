

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int l = 0;
        int r = 1;
        int tmp = l + r;
        while (r <= n) {
            if (tmp == n) {
                answer += 1;
                r += 1;
                tmp += r;
            } else {
                if (tmp > n) {
                    l += 1;
                    tmp -= l;
                } else {
                    r += 1;
                    tmp += r;
                }
            }
        }
//        if (n == 1) {
//            return answer;
//        }
        return answer;
    }
}
