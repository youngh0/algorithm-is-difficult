import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work: works){
            pq.add(work);
        }
        
        for(int i =0; i< n;i++){
            if(pq.size() == 0){
                break;
            }
            int maxWork = pq.poll();
            if(maxWork-1 == 0){
                continue;
            }
            pq.add(maxWork-1);
        }
        
        while(pq.size() > 0){
            int restWork = pq.poll();
            answer += restWork * restWork;
        }
        
        return answer;
    }
}