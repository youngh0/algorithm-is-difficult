import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> phoneSet = new HashSet<>();
        for(String phone: phone_book){
            phoneSet.add(phone);
        }
        
        StringBuilder sb;
        for(String phone: phone_book){
            phoneSet.remove(phone);
            sb = new StringBuilder();
            for(int i = 0;i < phone.length();i++){
                sb.append(phone.charAt(i));
                if(phoneSet.contains(sb.toString())){
                    // System.out.println(sb.toString());
                    return false;
                }
            }
            phoneSet.add(phone);
            
        }
        
        return true;
    }
}