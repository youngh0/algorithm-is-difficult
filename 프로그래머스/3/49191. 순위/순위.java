import java.util.*;

class Solution {
    public Map<Integer, List<Integer>> winMap = new HashMap<>();
    public Map<Integer, List<Integer>> defeatMap = new HashMap<>();
    
    public int solution(int n, int[][] results) {
        for(int i = 1;i < n+1;i++){
            winMap.put(i, new ArrayList<>());
            defeatMap.put(i, new ArrayList<>());
        }
        
        for(int[] result: results){
            int winner = result[0];
            int loser = result[1];
            
            List<Integer> winnerList = winMap.getOrDefault(winner, new ArrayList<Integer>());
            List<Integer> loserList = defeatMap.getOrDefault(loser, new ArrayList<Integer>());
            
            winnerList.add(loser);
            loserList.add(winner);
        }
        int answer = 0;
        for(int i = 1;i < n+1;i++){
            int winCount = bfs(i, n, winMap);
            int defeatCount = bfs(i, n, defeatMap);
            
            if(winCount + defeatCount == n-1){
                answer++;
            }
        }
        
    
        return answer;
    }
    
    public int bfs(int start, int n, Map<Integer, List<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        Deque<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int player: graph.get(cur)){
                if(visited[player]){
                    continue;
                }
                q.add(player);
                visited[player] = true;
                count++;
            }
        }
        return count;
        
    }
}