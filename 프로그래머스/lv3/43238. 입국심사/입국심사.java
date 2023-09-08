import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long)times[times.length-1] * n;
        
        long answer = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long completeCount = 0L;

            for (int time: times) { 
                completeCount += mid / time;
            }
        
            if(completeCount < n){
                left = mid+1;
            }else{
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}