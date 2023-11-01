// map 에 각 보석 별 마지막에 나온 숫자 관리
// map 사이즈가 모든 보석 종류와 같아지면 value 정렬해서 첫 번째, 마지막 반환

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};
        Set<String> gemsSet = new HashSet<>();
        
        for(String gem: gems){
            gemsSet.add(gem);
        }
        

        int length = gems.length;
        int start = 0;
        Map<String, Integer> gemsMap = new HashMap<>();
        for(int i = 0;i < gems.length;i++){
            gemsMap.put(gems[i], gemsMap.getOrDefault(gems[i],0) + 1);
            while(gemsMap.get(gems[start]) > 1){
                gemsMap.put(gems[start], gemsMap.get(gems[start])-1);
                start++;
            }
            
            if(gemsMap.size() == gemsSet.size()){
                if(i - start < length){

                    length = i - start;
                    answer = new int[]{start+1,i + 1};
                }
            }
        }
        
        
        return answer;
    }
}