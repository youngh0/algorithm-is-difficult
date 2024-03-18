import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        PriorityQueue<Class> pq = new PriorityQueue<>((o1,o2) -> o1.start - o2.start);
        for (String[] plan : plans) {
            String className = plan[0];
            String[] startTime = plan[1].split(":");
            int start = 0;
            start += Integer.parseInt(startTime[0]) * 60;
            start += Integer.parseInt(startTime[1]);
            int time = Integer.parseInt(plan[2]);
            pq.add(new Class(className, start, time));
        }
    
        List<String> answer = new ArrayList<>();
        List<Class> remaining = new ArrayList<>();
    
        while (answer.size() < plans.length) {
            if(!pq.isEmpty()){
                Class work = pq.poll();
                int curTime = work.start;
                if(!pq.isEmpty()){
                    Class next = pq.peek();
                    
                    if(curTime + work.time == next.start){
                        answer.add(work.name);
                        continue;
                    }else if(curTime + work.time > next.start){
                        int diff = next.start - work.start;
                        remaining.add(new Class(work.name, work.start, work.time - diff));
                        continue;
                    }else{
                        curTime += work.time;
                        answer.add(work.name);
                        while(!remaining.isEmpty()){
                            Class lastStop = remaining.remove(remaining.size()-1);
                            int lastFinish = lastStop.time + curTime;
                            if(lastFinish < next.start){
                                answer.add(lastStop.name);
                                curTime = lastFinish;
                            }else if(lastFinish == next.start){
                                answer.add(lastStop.name);
                                break;
                            }else{
                                remaining.add(new Class(lastStop.name, lastStop.start, lastStop.time - (next.start - curTime)));
                                break;
                            }
                        }
                    }
                }else{
                    // 현재 과제 끝내기
                    answer.add(work.name);
                }
                
            }else{
                // 멈춘 과제 수행
                while(!remaining.isEmpty()){
                    answer.add(remaining.remove(remaining.size()-1).name);
                }
            }
        }

        return answer.toArray(new String[answer.size()]);
    }

    public class Class {
        String name;
        int start;
        int time;

        public Class(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
}