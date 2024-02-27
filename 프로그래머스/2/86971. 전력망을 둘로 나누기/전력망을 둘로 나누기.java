import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<List<Integer>> wireList = new ArrayList<>();
        for(int i = 0;i < n+1;i++){
            wireList.add(new ArrayList<>());
        }

        for(int[] wire: wires){
            wireList.get(wire[0]).add(wire[1]);
            wireList.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire: wires){
            answer = Math.min(answer, bfs(wire[0], wire[1], wireList, n));
        }
        return answer;
    }
    
    public int bfs(int a, int b, List<List<Integer>> wireList, int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        boolean[] visited = new boolean[n+1];
        visited[a] = true;
        visited[b] = true;
        int count = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> nearList = wireList.get(cur);
            
            for(int near: nearList){
                if(visited[near]){
                    continue;
                }
                count++;
                q.add(near);
                visited[near] = true;
            }
        }
        
        q = new LinkedList<>();
        q.add(b);
        visited = new boolean[n+1];
        visited[a] = true;
        visited[b] = true;
        int countB = 1;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            List<Integer> nearList = wireList.get(cur);
            
            for(int near: nearList){
                if(visited[near]){
                    continue;
                }
                countB++;
                q.add(near);
                visited[near] = true;
            }
        }
        // System.out.println(a + " " + b + " " + count + " " + countB);
        return Math.abs(count - countB);
    }
}