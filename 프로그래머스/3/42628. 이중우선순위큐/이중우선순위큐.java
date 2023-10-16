import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        
        for(String operate: operations){
            String[] splitResult = operate.split(" ");
            String command = splitResult[0];
            int num = Integer.parseInt(splitResult[1]);
            if(command.equals("I")){
                maxQ.add(num);
                minQ.add(num);
            }else{
                if(minQ.size() == 0 && maxQ.size() == 0){
                    continue;
                }
                if(num == -1){
                    int pollNum = minQ.poll();
                    maxQ.remove(pollNum);
                }else{
                    int pollNum = maxQ.poll();
                    minQ.remove(pollNum);
                }
            }
        }
        if(minQ.size() == 0 && maxQ.size() == 0){
            return new int[]{0,0};
        }
        return new int[]{maxQ.peek(), minQ.peek()};
    }
}