import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        if(len == 1){
            return triangle[0][0];
        }
        if(len == 2){
            return Math.max(triangle[1][0] + triangle[0][0], + triangle[1][1] + triangle[0][0]);
        }
        
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        for(int i = 0;i < len-1;i++){
            for(int j = 0; j < triangle[i].length;j++){
                dp[i+1][j] = Math.max(dp[i][j] + triangle[i+1][j], dp[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i][j] + triangle[i+1][j+1], dp[i+1][j+1]);
            }
        }
        
        for(int a: dp[len-1]){
            answer = Math.max(answer, a) ;   
        }
        return answer;
    }
}