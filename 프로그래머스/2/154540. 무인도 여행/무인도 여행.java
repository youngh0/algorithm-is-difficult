import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};
    
    public int[] solution(String[] maps) {
        
        int row = maps.length;
        int col = maps[0].length();
        
        visited = new boolean[row][col];
        String[][] map = new String[row][col];
        
        for(int j = 0; j < row; j++){
            String oneRow = maps[j];
            for(int i = 0;i < col;i++){
                map[j][i] = String.valueOf(oneRow.charAt(i));
            }
        }
        
        List<Integer> foods = new ArrayList<>();
        
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(map[i][j].equals("X") || visited[i][j]){
                    continue;
                }
                foods.add(bfs(i, j, map));
            }
        }
        
        if(foods.isEmpty()){
            return new int[]{-1};
        }
        
        Collections.sort(foods);
        int[] answer = new int[foods.size()];
        for(int i = 0;i < foods.size();i++){
            answer[i] = foods.get(i);
        }
        return answer;
    }
    
    public int bfs(int startR, int startC, String[][] map){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        int count = Integer.parseInt(map[startR][startC]);
        
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int r = polled[0];
            int c = polled[1];
            
            for(int i = 0;i < 4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length || map[nr][nc].equals("X")){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                // System.out.println(map[nr][nc] + " " + nr + " " + nc);
                count += Integer.parseInt(map[nr][nc]);
                visited[nr][nc] = true;
                q.add(new int[]{nr,nc});
            }
        }
        return count;
    }
}