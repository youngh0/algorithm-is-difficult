import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int total = citations.length;
        
        Arrays.sort(citations);
        int index = 0;
        
        for(int i = 0; i < total;i++){
            int citationCount = total - i;
            
            if (citations[i] >= citationCount) {
                answer = citationCount;
                break;
            }
            
        }
    
        return answer;
    }
}