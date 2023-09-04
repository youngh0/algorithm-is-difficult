import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();
        
        for(long i = left; i < right+1;i++){
            long x = i / (long)n;
            long y = i % (long)n;
            
            if(y <= x){
                // answer[i-left] = x + 1;
                answer.add(x + 1);
            }
            else{
                // answer[i-left] = y + 1;
                answer.add(y + 1);
            }
        }
        return answer.stream()
            .mapToInt(Long::intValue)
            .toArray();
    }
}