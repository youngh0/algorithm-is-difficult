import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long[][] dp = new long[sequence.length][2];
        
        dp[0][0] = Math.max(sequence[0], 0);
        dp[0][1] = Math.max(-1 * sequence[0], 0);
        answer = Math.max(dp[0][0], dp[0][1]);
        
        for(int i = 1;i < sequence.length;i++){
            dp[i][0] = Math.max(dp[i-1][1] + sequence[i], 0);
            dp[i][1] = Math.max(dp[i-1][0] + (-1 * sequence[i]), 0);
            long maxNum = Math.max(dp[i][0], dp[i][1]);
            answer = Math.max(answer, maxNum);
        }
    
        return answer;
    }
}