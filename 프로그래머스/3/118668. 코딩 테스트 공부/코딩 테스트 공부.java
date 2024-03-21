import java.util.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        // max alp, max cop 구하기
        int maxAlp = 0;
        int maxCop = 0;
        
        for(int[] problem: problems){
            maxAlp = Math.max(problem[0], maxAlp);
            maxCop = Math.max(problem[1], maxCop);
        }
        
        if(maxAlp <= alp && maxCop <= cop){
            return 0;
        }
        
        int[][] dp = new int[maxAlp + 2][maxCop + 2];
        for(int[] d : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        
        
        
        alp = Math.min(alp, maxAlp);
        cop = Math.min(cop, maxCop);
        dp[alp][cop] = 0;
        for(int i = alp; i < maxAlp + 1;i++){
            for(int j = cop; j < maxCop + 1; j++){
                dp[i+1][j] = Math.min(dp[i][j] + 1, dp[i+1][j]);
                dp[i][j+1] = Math.min(dp[i][j] + 1, dp[i][j+1]);
                
                for(int[] problem: problems){
                    if(i >= problem[0] && j >= problem[1]){
                        
                        int alpLevel = Math.min(i + problem[2], maxAlp);
                        int copLevel = Math.min(j + problem[3], maxCop);
                        dp[alpLevel][copLevel] = Math.min(dp[i][j] + problem[4], dp[alpLevel][copLevel]);
                    }
                }
            }
        }
        return dp[maxAlp][maxCop];
        
    }
}