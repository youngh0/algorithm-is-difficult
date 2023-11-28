class Solution {
    int[] dp;
    
    public int solution(int n, int[] money) {
        int answer = 0;
        
        dp = new int[n+1];
        
        dp[0] = 1;
        
        // dp[n] = dp[n-money[i]] + dp[n - money[i]]
        
        for(int mon: money){
            for(int i = 1;i < n+1;i++){
                if(i - mon < 0){
                    continue;
                }
                dp[i] += dp[i - mon];
            }
        }
        
        // 1
        // (1,1) 2
        // (1,1,1) (1,2) 3
        // 
 
        return dp[n];
    }
}