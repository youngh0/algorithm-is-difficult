import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String, Integer> clusterMap = new HashMap<>();
        
        for(int i = 0;i < str1.length()-1;i++){ 
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
                String key = str1.substring(i, i + 2).toUpperCase();
                int curVal = clusterMap.getOrDefault(key, 0);
                clusterMap.put(key, curVal+1);
            }
            
        }
        
        Map<String, Integer> clusterMap2 = new HashMap<>();
        for(int i = 0;i < str2.length()-1;i++){ 
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
                String key = str2.substring(i, i + 2).toUpperCase();
                int curVal = clusterMap2.getOrDefault(key, 0);
                clusterMap2.put(key, curVal+1);
            }
            
        }
        
        for(String key: clusterMap.keySet()){
            System.out.println(key + " " + clusterMap.get(key));    
        }
        System.out.println("------");    
        for(String key: clusterMap2.keySet()){
            System.out.println(key + " " + clusterMap2.get(key));     
        }
        
        int sum = 0;
        for(int val: clusterMap.values()){
            sum += val;
        }
        
        int same = 0;
        for(String key: clusterMap2.keySet()){ 
            if(clusterMap.containsKey(key)){
                if(clusterMap2.get(key) > clusterMap.get(key)){
                    sum += clusterMap2.get(key) - clusterMap.get(key);
                }
                same += Math.min(clusterMap2.get(key), clusterMap.get(key));
            }else{
                sum += clusterMap2.get(key);
            }
        }
        if(clusterMap.size() == 0 && clusterMap2.size() == 0){
            return 65536;
        }

        double aa = (double)same / (double)sum * 65536;  
        
        
        return (int) aa;
    }
}