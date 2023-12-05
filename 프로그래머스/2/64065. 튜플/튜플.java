import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<Integer> set = new HashSet<>();
        
        s = s.substring(2);
        s = s.substring(0, s.length()-2);
        s = s.replace("},{", " ");
        
        String[] a = s.split(" ");
        Arrays.sort(a, (o1, o2) -> o1.split(",").length - o2.split(",").length);
        List<Integer> tupleList = new ArrayList<>();
        
        for(String f: a){
            String[] splitArray = f.split(",");
            for(String splitString: splitArray){
                int splitInt = Integer.parseInt(splitString);
                if(!set.contains(splitInt)){
                    tupleList.add(splitInt);
                }
                set.add(splitInt);
            }
        }
        
        int[] answer = new int[tupleList.size()];
        
        for(int i = 0;i < answer.length;i++){
            answer[i] = tupleList.get(i);
        }
        return answer;
    }
}