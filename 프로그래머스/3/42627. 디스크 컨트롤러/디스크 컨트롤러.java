import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        int curTime = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        boolean[] completed = new boolean[jobs.length];
        int jobCount = 0;
        int jobIdx = 0;
        
        while(jobCount != jobs.length){
            while(jobIdx < jobs.length && jobs[jobIdx][0] <= curTime){
                pq.add(jobs[jobIdx]);
                jobIdx++;
            }
            
            if(pq.isEmpty()){
                curTime = jobs[jobIdx][0];
            }else{
                int[] curJob = pq.poll();
                answer += (curJob[1] + curTime) - curJob[0];
                curTime += curJob[1];
                jobCount++;
            }    
        }
        
        
        return answer / jobs.length;
    }
}