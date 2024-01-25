import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y*3+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        dp[x + n] = 1;
        dp[x * 2] = 1;
        dp[x * 3] = 1;
        
        for(int i = x; i < y+1;i++){
            if(dp[i] == Integer.MAX_VALUE){
                continue;
            }
            
                dp[i + n] = Math.min(dp[i+n], dp[i] + 1);    
            
            
                dp[i * 2] = Math.min(dp[i*2], dp[i] + 1);
            
            
                dp[i * 3] = Math.min(dp[i*3], dp[i] + 1);
            
        }
        if(dp[y] == Integer.MAX_VALUE){
            return -1;
        }
        return dp[y];
    }
}