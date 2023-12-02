// import java.util.*

class Solution {
    boolean[] visited;
    int[][] dungeonCopy;
    int maxCount;
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[k];
        maxCount = dungeons.length;
        dungeonCopy = dungeons;
        dfs(0, 0, k);
        return answer;
    }
    
    public void dfs(int depth, int count, int rest){
        if(depth == maxCount){
            answer = Math.max(answer, count);
            return;
        }
        
        for(int i = 0; i < maxCount;i++){
            if(visited[i]){
                continue;
            }
            if(rest >= dungeonCopy[i][0]){
                visited[i] = true;
                dfs(depth+1, count+1, rest - dungeonCopy[i][1]);
            }else{
                dfs(depth+1, count, rest);
            }
            visited[i] = false;
        }
    }
}