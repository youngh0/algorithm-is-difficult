import java.util.*;

class Solution {
    
    boolean[] visited;
    int count;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] cards) {
        visited = new boolean[cards.length + 1];
        int answer = 0;

        for(int i = 0;i < cards.length;i++){
            if(!visited[i + 1]){
                System.out.println("call");
                dfs(i + 1, cards, 0);
            }
        }
        
        if(pq.size() == 1){
            return 0;
        }
        
        return pq.poll() * pq.poll();
    }
    
    public void dfs(int nextIdx, int[] cards, int cur){
        if(visited[nextIdx]){
            System.out.println(nextIdx + " " + cur);
            pq.add(cur);
            return;
        }
        visited[nextIdx] = true;
        dfs(cards[nextIdx - 1], cards, cur+1);
    }
}