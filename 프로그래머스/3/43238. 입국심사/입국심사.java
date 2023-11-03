import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        Arrays.sort(times);
        long right = (long) times[times.length-1] * n;
        long answer = right;
        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            
            for(int time: times){
                count += mid / time;
            }
            
            if(count < n){
                left = mid + 1;
            }else{
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}