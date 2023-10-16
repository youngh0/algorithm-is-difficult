import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int n = sticker.length;
        if(n == 1){
            return sticker[0];
        }
        
        if(n < 3){
            return Math.max(sticker[0], sticker[1]);
        }
        
        int[][] dp = new int[2][n];
        
        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        
        dp[1][0] = 0;
        dp[1][1] = sticker[1];
        
        for(int i = 2;i < n - 1;i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + sticker[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + sticker[i]);
        }
        
        
        
        dp[1][n-1] = Math.max(dp[1][n-2], sticker[n-1] + dp[1][n-3]);
    
        return Math.max(dp[1][n-1], dp[0][n-2]);
    }
}