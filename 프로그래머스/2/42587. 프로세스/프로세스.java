import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Process> processList = new ArrayDeque<>();
        for(int i = 0;i < priorities.length;i++){
            pq.add(priorities[i]);
            processList.addLast(new Process(i, priorities[i]));
        }
        
        int curPri = pq.poll();
        while(!pq.isEmpty()){
            if(processList.peek().priority == curPri){
                if(processList.peek().number == location){
                    return answer;
                }
                else{
                    // System.out.println(curPri + ", " + processList.peek().priority + " " + processList.peek().number);
                    answer++;
                    processList.removeFirst();
                }
                curPri = pq.poll();
            }else{
                processList.addLast(processList.removeFirst());
            
            }
        }
                
        return answer;
    }
}

class Process{
        public int number;
        public int priority;
        
        public Process(int number, int priority){
            this.number = number;
            this.priority = priority;
        }
    }