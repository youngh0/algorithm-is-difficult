class Solution {
    long answer = 0;
    public long solution(int n) {  
        int[] dp = new int[n+3];
        dp[1] = 1;
        dp[2] = 2;
    
        for(int i = 3;i < n+1;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
    
    public void jump(int distance, int target){
        if(distance == target){
            answer %= 1234567;
            answer++;
            return;
        }
        if(distance > target){
            return;
        }
        
        jump(distance + 1, target);
        jump(distance + 2, target);
    }
}