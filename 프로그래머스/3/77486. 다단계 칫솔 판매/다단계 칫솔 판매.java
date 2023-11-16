import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, String> referralMap = new HashMap<>();
        Map<String, Integer> earnMap = new HashMap<>();
        
        for(int i = 0;i < enroll.length;i++){
            String member = enroll[i];
            String recommender = referral[i];
            
            referralMap.put(member, recommender);
            earnMap.put(member, 0);
        }
        
    
        
        for(int i = 0;i < seller.length;i++){
            String sellerString = seller[i];
            int sellTotal = amount[i] * 100;
            
            
            while(true){
                if(sellTotal / 10 < 1){
                    earnMap.put(sellerString, earnMap.get(sellerString) + sellTotal);
                    break;
                }
                int minusTenTotal = sellTotal - (sellTotal / 10);
                earnMap.put(sellerString, earnMap.get(sellerString) + minusTenTotal);
                sellTotal = sellTotal / 10;
                sellerString = referralMap.get(sellerString);
                if(sellerString.equals("-")){
                    break;
                }
            }
        }
        // for(String key: enroll){
        //     System.out.println(key + " " + earnMap.get(key));
        // }
        
        for(int i = 0;i < enroll.length;i++){
            answer[i] = earnMap.get(enroll[i]);
        }
        
        return answer;
    }
}