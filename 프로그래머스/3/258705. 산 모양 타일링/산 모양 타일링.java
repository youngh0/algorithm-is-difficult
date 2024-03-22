import java.util.*;

class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[]dp1 = new int[n+1];
        int[]dp2 = new int[n+1];
        
        dp1[0] = 2 + tops[0];
        dp2[0] = 1;
        
        for(int i = 1; i < n;i++){
            dp1[i] = (dp2[i-1] * (1 + tops[i]) + dp1[i-1] * (2 + tops[i])) % 10007;
            dp2[i] = (dp1[i-1] + dp2[i-1]) % 10007;
        }
           
        return (dp1[n-1] + dp2[n-1]) % 10007;
    }
}