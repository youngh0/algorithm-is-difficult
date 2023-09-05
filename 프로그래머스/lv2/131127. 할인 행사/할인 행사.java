import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wants = new HashMap<>();
        
        for(int i = 0; i < want.length;i++){
            wants.put(want[i], number[i]);
        }
        
        for(int start = 0; start < discount.length - 10 + 1; start++){
            Map<String, Integer> sales = new HashMap<>();
            for(int day = 0; day < 10; day++){
                String saleProduct = discount[day + start];
                if(!wants.containsKey(saleProduct)){
                    break;
                }
                int saleCount = sales.getOrDefault(saleProduct, 0);
            
                if(saleCount >= wants.get(saleProduct)){
                    break;
                }
                
                sales.put(saleProduct, saleCount+1);
            }
            // System.out.println("day: " + start);
            // for(String key: sales.keySet()){
                // System.out.println("key: " + key + ", value: " + sales.get(key));
            // }
//             for(String wantProduct: want){
//                 if(!sales.containsKey(wantProduct)){
                    
//                 }
//             }
            if(sales.size() != number.length){
                continue;
            }
            boolean flag = true;
            for(int i = 0; i < number.length;i++){
                if(sales.get(want[i]) != number[i]){
                    flag = false;
                    break;
                }
            }
            
            
            if(flag){
                answer++;
            }
            
            
        }
        
        return answer;
    }
}