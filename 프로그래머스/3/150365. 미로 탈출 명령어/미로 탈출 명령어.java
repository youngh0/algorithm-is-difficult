import java.util.*;

class Solution {
    
    int[] dr = {1, 0,0,-1};
    int[] dc = {0, -1,1,0};
    Map<Integer, String> directionMap = new HashMap<>();
    PriorityQueue<String> pq = new PriorityQueue<>();
    StringBuilder curPath = new StringBuilder();
    String answer;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        directionMap.put(0, "d");
        directionMap.put(1, "l");
        directionMap.put(2, "r");
        directionMap.put(3, "u");
        
        int distance = Math.abs(x - r) + Math.abs(y - c);
        if(distance % 2 != k % 2 || k < distance){
            return "impossible";
        }
        
        dfs(x-1, y-1, r-1, c-1, 0, k,n,m);
        
        if(answer == null){
            return "impossible";
        }
        
        return answer;
    }
    

    
    public void dfs(int row, int col, int endRow, int endCol, int depth, int k, int n, int m){
        if(answer != null){
            return;
        }
        
        int distance = Math.abs(row - endRow) + Math.abs(col - endCol);
        if(depth + distance > k){
            return;
        }
        if((k - depth) % 2 != distance % 2){
            return;
        }
        if(depth == k && row == endRow && col == endCol){
            answer = curPath.toString();
        }
        
        for(int i = 0;i < 4;i++){
            if(row + dr[i] < 0 || col + dc[i] < 0 || row + dr[i] >= n || col + dc[i] >= m){
               continue;
            }
            curPath.append(directionMap.get(i));
            dfs(row + dr[i], col + dc[i], endRow, endCol, depth+1,k,n,m);
            curPath.delete(depth, depth+1);
        }
    }
}

