import java.util.*;

class Solution {
    static boolean[][] visited;
    static Character[][] map;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    
    public int solution(String[] board) {
        int answer = 0;
        
        map = new Character[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        
        for(int i = 0;i < board.length;i++){
            String row = board[i];
            for(int j = 0;j < row.length();j++){
                map[i][j] = row.charAt(j);
            }
        }
        
        for(int i = 0;i < board.length;i++){
            for(int j = 0;j < map[0].length;j++){
                if(map[i][j] == 'R'){
                    System.out.println(i + " " + j);
                    return bfs(i,j);
                }
            }
        }
        
        
        
        return answer;
    }
    
    public int bfs(int startR, int startC){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC, 0});
        
        while(!q.isEmpty()){
            int[] polled = q.poll();
            
            int row = polled[0];
            int col = polled[1];
            int val = polled[2];
            
            for(int i = 0; i < 4;i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                
                if(nr == map.length || nc == map[0].length || nr < 0 || nc < 0){
                    continue;
                }
                
                if(map[nr][nc] == 'D'){
                    continue;
                }
                
                while(nc >= 0 && nr >= 0 && nr < map.length && nc < map[0].length && map[nr][nc] != 'D'){
                    nr += dr[i];
                    nc += dc[i];
                }
                
                nr -= dr[i];
                nc -= dc[i];
                
                if(map[nr][nc] == 'G'){
                    return val+1;
                }
                
                if(visited[nr][nc]){
                    continue;
                }
                
                q.add(new int[]{nr, nc, val + 1});
                visited[nr][nc] = true;

            }
        }
        return -1;
    }
}