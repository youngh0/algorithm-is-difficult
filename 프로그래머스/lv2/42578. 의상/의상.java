import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        
        Map<String, Integer> clothMap = new HashMap<>();
        
        for(String cloth[] : clothes){
            int value = clothMap.getOrDefault(cloth[1], 0);
            clothMap.put(cloth[1], value + 1);
        }
        
        

            int mul = 1;
            for(String key: clothMap.keySet()){
                mul *= clothMap.get(key) + 1;
            }    
            answer += mul - 1;
    
        
        return answer;
    }
}