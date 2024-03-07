import java.util.*;

class Solution {
    boolean[][] visited;
    
    public int solution(int N, int[][] road, int K) {
        
        visited = new boolean[N+1][N+1];
        
        List<List<int[]>> map = new ArrayList<>();
        
        for(int i = 0; i < N+1;i++){
            map.add(new ArrayList<>());
        }
        
        for(int[] r: road){
            int start = r[0];
            int end = r[1];
            int cost = r[2];
            
            map.get(start).add(new int[]{end, cost});
            map.get(end).add(new int[]{start, cost});
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{1,0});
        dist[1] = 0;
        
        while(!q.isEmpty()){
            int[] polled = q.poll();
            int cur = polled[0];
            int cost = polled[1];
            
            if(dist[cur] < cost){
                continue;
            }
            
            List<int[]> neighbor = map.get(cur);
            for(int[] neigh : neighbor){
                int dest = neigh[0];
                int fee = neigh[1];
                
                int total = cost + fee;
                if(dist[dest] > total){
                    
                
                    dist[dest] = total;
                    q.add(new int[]{dest, total});
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i < N + 1;i ++){
            System.out.print(dist[i] + " ");
            if(dist[i] <= K){
                answer++;
            }
        }
        return answer;
    }
}