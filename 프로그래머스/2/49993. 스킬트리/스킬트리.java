import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Set<Character> skillTreeSet = new HashSet<>();
       
        
        for(int i = 0;i < skill.length();i++){
            skillTreeSet.add(skill.charAt(i));
            
        }
        
        for(String skillTree: skill_trees){
            boolean flag = true;
            int cur = 0;
            for(int i = 0;i < skillTree.length();i++){
                if(skillTreeSet.contains(skillTree.charAt(i))){
                    if(skill.charAt(cur) != skillTree.charAt(i)){
                        System.out.println(skillTree + " " + i);
                        flag = false;
                        break;
                    }else{
                        cur++;
                    }
                }
            }
            if(flag){
                answer++;
            }
        }
        return answer;
    }
}