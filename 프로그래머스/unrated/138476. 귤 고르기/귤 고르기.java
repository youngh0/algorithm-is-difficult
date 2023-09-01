import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> tangerines = new HashMap<>();
        
        for(int tang : tangerine){
            int count = tangerines.getOrDefault(tang, 0);
            tangerines.put(tang, count + 1);
        }
        List<Integer> keys = new ArrayList<>(tangerines.keySet());
        Collections.sort(keys, (o1,o2) -> (tangerines.get(o2).compareTo(tangerines.get(o1))));
        
        for(int key : keys){
            int value = tangerines.get(key);
            if(value >= k){
                return answer + 1;
            }
            
            answer++;
            k -= value;
        }
        return answer;
    }
}