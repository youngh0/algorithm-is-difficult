import java.util.*;

class Solution {
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        int[] parents = new int[2501];
        String[] values = new String[2501];
        
        for(int i = 0; i < 2501;i++){
            parents[i] = i;
            values[i] = "";
        }
        
        for(String command: commands){
            String[] commandArr = command.split(" ");
            
            if(commandArr[0].equals("UPDATE")){
                if(commandArr.length == 4){
                    int r = Integer.parseInt(commandArr[1]);
                    int c = Integer.parseInt(commandArr[2]);
                    String value = commandArr[3];
                    
                    updateByLoc(values,r,c,value,parents);
                }else{
                    String before = commandArr[1];
                    String after = commandArr[2];
                    
                    updateByValue(values,before, after);
                }
            }else if(commandArr[0].equals("MERGE")){
                int r1 = Integer.parseInt(commandArr[1]);
                int c1 = Integer.parseInt(commandArr[2]);
                int r2 = Integer.parseInt(commandArr[3]);
                int c2 = Integer.parseInt(commandArr[4]);
                
                merge(r1,c1,r2,c2,parents,values);
            }else if(commandArr[0].equals("UNMERGE")){
                int r1 = Integer.parseInt(commandArr[1]);
                int c1 = Integer.parseInt(commandArr[2]);
                unmerge(r1,c1, parents, values);
            }else{
                int r1 = Integer.parseInt(commandArr[1]);
                int c1 = Integer.parseInt(commandArr[2]);
                
                if(values[find(convert(r1,c1), parents)].isBlank()){
                    answer.add("EMPTY");
                }else{
                    answer.add(values[find(convert(r1,c1), parents)]);    
                }
                
            }
        }
        
        String[] a = new String[answer.size()];
        for(int i = 0;i < answer.size();i++){
            a[i] = answer.get(i);
        }
        return a;
    }
    
    public int find(int idx, int[] parents){
        if(parents[idx] == idx){
            return parents[idx];
        }
        return parents[idx] = find(parents[idx], parents);
    }
    
    public void union(int a, int b, int[] parents){
        int aParent = find(a, parents);
        int bParent = find(b, parents);
        
        parents[bParent] = aParent;
    }
    
    public void updateByLoc(String[] values, int r, int c, String value, int[] parents){
        int idx = convert(r, c);
        values[find(idx, parents)] = value;
    }
    
    public void merge(int r1, int c1, int r2, int c2, int[] parents, String[] values){
        int parent1 = find(convert(r1,c1), parents);
        int parent2 = find(convert(r2,c2), parents);
        
        if(parent1 == parent2){
            return;
        }
        
        String after;
        if(values[parent1].isBlank()){
            after = values[parent2];
        }else{
            after = values[parent1];
        }
        
        values[parent1] = "";
        values[parent2] = "";
        union(parent1, parent2, parents);
        values[find(parent1, parents)] = after;
        
        // System.out.println(parent1 + " " + parent2);
        // System.out.println(values[parent1] + " " + values[parent2]);
        // System.out.println(parents[convert(r1,c1)] + " " + parents[convert(r2,c2)]);
    }
    
    public void unmerge(int r, int c, int[] parents, String[] values){
        int idx = convert(r,c);
        int parent = find(idx, parents);
        String before = values[parent];
        
        values[parent] = "";
        
        // for(int i = 0;i < 2501;i++){
        //     if(parents[i] == parent){
        //         parents[i] = i;
        //         values[i] = "";
        //     }
        // }
        // values[idx] = before;
        List<Integer> deleteList = new ArrayList<>();
        for (int i = 1; i <= 2500; i++) {
            if (find(i, parents) == parent)
                deleteList.add(i);
        }
        for (Integer t : deleteList)
            parents[t] = t;
        
        values[idx] = before;
    }
    
    public void updateByValue(String[] values, String before, String after){
        
        for(int i = 0;i < values.length;i++){
            if(values[i].equals(before)){
                values[i] = after;
            }
        }
    }
    
    public int convert(int r, int c){
        return (r-1) * 50 + c;
    }
}