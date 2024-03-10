import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(k > enemy.length){
            return enemy.length;
        }
        for(int i = 0;i < k;i++){
            pq.add(enemy[i]);
        }
        
        int idx = k;
        while(n > 0 && idx <enemy.length){
            n -= enemy[idx];
            if(!pq.isEmpty() && enemy[idx] > pq.peek()){
                n += enemy[idx];
                n -= pq.poll();
                pq.add(enemy[idx]);
            }
            idx++;
        }
        if(n < 0){
            idx--;
        }
        return idx;
    }
}