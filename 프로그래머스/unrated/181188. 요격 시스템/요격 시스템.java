import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparing((int[] o) -> o[1]));
        int answer = 0;
        int current = 0;
        for (int[] target : targets) {
            if (target[0] >= current) {
                current = target[1];
                answer++;
            }
        }
        return answer;
    }
}