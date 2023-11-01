import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 0;
        int right = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = (left + right) / 2;
            boolean flag = true;
            int count = 0;
            
            for(int stone: stones){
                if(stone < mid){
                    count++;
                    if(count >= k){
                        flag = false;
                        break;
                    }
                }else{
                    count = 0;
                }
                
            
            }
            
            if(!flag){
                right = mid - 1;
            }else{
                left = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}