import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String str = String.valueOf(n);
        
        for(int i = 0;i < str.length();i++){
            pq.add(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        return Long.valueOf(sb.toString());
        // return answer;
    }
}