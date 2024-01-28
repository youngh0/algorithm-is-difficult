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
        
        
        while(answer < order.length){
            if(order[answer] == youngjae){
                answer++;
                youngjae++;
            }
            else if(order[answer] > youngjae){
                second.add(youngjae);
                youngjae++;
                // for(int i = youngjae; i < order[answer] + 1; i++){
                    
                // }
                // youngjae = order[answer] + 1;
                // answer++;
                
            }
            else if(order[answer] < youngjae){
                if(second.isEmpty() || second.get(second.size()-1) != order[answer]){
                    break;    
                }else if(second.get(second.size()-1) == order[answer]){
                    second.remove(second.size()-1);
                    answer++;
                }
            } 
        }
        
        
        return answer;
    }
}