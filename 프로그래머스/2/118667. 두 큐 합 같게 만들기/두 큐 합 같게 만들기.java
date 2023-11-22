import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Deque<Long> q1 = new ArrayDeque<>();
        Deque<Long> q2 = new ArrayDeque<>();
        
        long total = 0;
        long q1Total = 0;
        long q2Total = 0;
        
        for(int i = 0;i < queue1.length;i++){
            total += queue1[i];
            total += queue2[i];
            
            q1.addLast(Long.valueOf(queue1[i]));
            q2.addLast(Long.valueOf(queue2[i]));
            
            q1Total += Long.valueOf(queue1[i]);
            q2Total += Long.valueOf(queue2[i]);
        }
        
        if(total % 2 == 1){
            return -1;
        }
        int maxCount = queue1.length + queue2.length;
        
        for(int i = 0; i < maxCount+3;i++){
            if(q1Total == q2Total){
                return i;
            }
            if(q1Total < q2Total){
                long first = q2.removeFirst();
                q1.addLast(first);
                q1Total += first;
                q2Total -= first;
            }
            else{
                long first = q1.removeFirst();
                q2.addLast(first);
                q2Total += first;
                q1Total -= first;
            }
        }
        
        int answer = -1;
        return -1;
    }
}