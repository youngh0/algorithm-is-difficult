import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int arr[][] = new int[n][n];
        int x = -1, y = 0;
        int max = n * (n+1)/2;
        
        int cnt = 1;
        
        while(cnt <= max){
            while(x + 1 < n && arr[x + 1][y] == 0){
                // System.out
                arr[x + 1][y] = cnt++;
                x++;
            }
            
            while(y + 1 < n && arr[x][y+1] == 0){
                arr[x][y+1] = cnt++;
                y++;
            }
            
            while(x - 1 > -1 && y - 1 > -1 && arr[x-1][y-1] == 0){
            
                arr[x-1][y-1] = cnt++;
                x--;
                y--;
            }
            System.out.println(cnt);
            
        }
        int[] answer = new int[max];
        int idx = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0; j < i+1; j++){
                answer[idx] = arr[i][j];
                idx++;
            }   
        }

        
        return answer;
    }
}