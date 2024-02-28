import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max = -1;
        
        Map<String, String> map = new HashMap<>();
        map.put("C#", "H");
        map.put("D#", "I");
        map.put("A#", "J");
        map.put("F#", "K");
        map.put("G#", "L");
        
        for(String musicInfo: musicinfos){
            String[] infoArray = musicInfo.split(",");
            
            String[] startTimeArr = infoArray[0].split(":");
            // String startTime = startTimeArr[0] + startTimeArr[1];
            
            String[] endTimeArr = infoArray[1].split(":");
            // String endTime = endTimeArr[0] + endTimeArr[1];
            
            String title = infoArray[2];
            String music = infoArray[3];
            
            int intStart = Integer.parseInt(startTimeArr[0]) * 60 + Integer.parseInt(startTimeArr[1]);
            int intEnd = Integer.parseInt(endTimeArr[0]) * 60 + Integer.parseInt(endTimeArr[1]);

            int hour = (intEnd - intStart) / 100;
            int minute = (intEnd - intStart) % 100;
            // int total = hour * 60 + minute;
            int total = intEnd - intStart;

            List<String> soundList = new ArrayList<>();
            for(int i = 0;i < music.length();i++){
                if(music.charAt(i) != '#'){
                    soundList.add(String.valueOf(music.charAt(i)));
                }else{
                    String sound = soundList.remove(soundList.size()-1);
                    soundList.add(sound + "#");
                }
            }
            List<String> mList = new ArrayList<>();
            for(int i = 0;i < m.length();i++){
                if(m.charAt(i) != '#'){
                    mList.add(String.valueOf(m.charAt(i)));
                }else{
                    String sound = mList.remove(mList.size()-1);
                    mList.add(sound + "#");
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < total;i++){
                int idx = i % soundList.size();
                if(map.containsKey(soundList.get(idx))){
                    sb.append(map.get(soundList.get(idx)));
                }else{
                    sb.append(soundList.get(idx));    
                }   
            }
            
            StringBuilder mBuilder = new StringBuilder();
            
            for(int i = 0; i < mList.size();i++){
                if(map.containsKey(mList.get(i))){
                    mBuilder.append(map.get(mList.get(i)));
                }else{
                    mBuilder.append(mList.get(i));    
                }
            }
            
            String melody = sb.toString();
            if(melody.contains(mBuilder.toString()) && total > max){
                answer = title;
                max = total;
            }
        }
        if(max == -1 ){
            return "(None)";
        }
        return answer;
    }
}