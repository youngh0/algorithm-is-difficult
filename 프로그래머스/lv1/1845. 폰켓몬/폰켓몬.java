

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int num : nums) {
            Integer value = maps.getOrDefault(num, 0);
            maps.put(num, value + 1);
        }

        int maxSize = nums.length / 2;
        
        int answer = 0;
        if (maps.size() < maxSize) {
            answer = maps.size();
        } else {
            answer = maxSize;
        } 
        return answer;
    }
}
