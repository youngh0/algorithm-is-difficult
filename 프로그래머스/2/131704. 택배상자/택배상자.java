import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 1;
        
        List<Integer> second = new ArrayList<>();
        // int curDelivery = order[0];
        int youngjae = order[0] + 1;
        
        for(int i = 1;i < order[0];i++){
            second.add(i);
        }
        
        while(true){
            if(answer == order.length){
                break;
            }
            if(order[answer] == youngjae){
                answer++;
                youngjae++;
            }
            else if(second.isEmpty()){
                break;
            }
            else if(second.get(second.size()-1) == order[answer]){
                second.remove(second.size()-1);
                answer++;
            }
            else if(order[answer] > youngjae){
                for(int i = youngjae; i < order[answer] + 1; i++){
                    second.add(i);
                }
                youngjae = order[answer] + 1;
                answer++;
                continue;
            }
            else if(order[answer] < youngjae){
                break;
            }
            
            
        }
        
        
        return answer;
    }
}