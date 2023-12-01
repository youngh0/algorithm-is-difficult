class Solution {
    int[] dp;
    
    public int solution(int n) {
        int answer = 0;
        dp = new int[n+1];
        dfs(n);

        return dp[n] % 1234567;
    }
    
    public int dfs(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            dp[n] = 1;
            return 1;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        int nOne = (dfs(n-1)%1234567);
        int nTwo = (dfs(n-2)%1234567);

        dp[n] = (nOne + nTwo) % 1234567;
        return dp[n];
    }
}