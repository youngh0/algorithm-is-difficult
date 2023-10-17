import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        PriorityQueue<Integer> aQ = new PriorityQueue<>();
        PriorityQueue<Integer> bQ = new PriorityQueue<>();
        
        for(int i = 0; i < A.length;i++){
            aQ.add(A[i]);
            bQ.add(B[i]);
        }
        
        while(!bQ.isEmpty()){
            if(aQ.peek() < bQ.peek()){
                answer++;
                aQ.poll();
                bQ.poll();
                continue;
            }
            bQ.poll();
        }
        
        return answer;
    }
}