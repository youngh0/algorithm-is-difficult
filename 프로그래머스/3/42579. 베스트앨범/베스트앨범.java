import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genre = new HashMap<>();
        Map<String, List<Music>> musics = new HashMap<>();
        
        for(int i = 0;i < plays.length;i++){
            int play = genre.getOrDefault(genres[i], 0);
            genre.put(genres[i], play + plays[i]);
            
            Music music = new Music(plays[i], i);
            if(musics.containsKey(genres[i])){
                musics.get(genres[i]).add(music);
            }else{
                List<Music> mList = new ArrayList<>();
                mList.add(music);
                musics.put(genres[i],mList);
            }
        }
        
        List<String> keySet = new ArrayList<>(genre.keySet());
        keySet.sort((o1, o2) -> genre.get(o2) - genre.get(o1));
        
        int curIdx = 0;
        
        for(String key: keySet){
            List<Music> musicList = musics.get(key);
            Collections.sort(musicList, (o1,o2) -> {
                if(o1.playCount == o2.playCount){
                    return o1.index - o2.index;
                }
                return o2.playCount - o1.playCount;
            });
        }
        
        List<Integer> answerIdx = new ArrayList<>();
        for(String key: keySet){
            List<Music> musicList = musics.get(key);
            if(musicList.size() > 2){
                for(int i = 0;i < 2;i++){
                    answerIdx.add(musicList.get(i).index);
                
                }
                
            }else{
                for(int i = 0;i < musicList.size();i++){
                    answerIdx.add(musicList.get(i).index);
                    
                }
            }
        }
        
        return answerIdx.stream().mapToInt(x -> x).toArray();
        
//         for(String a: keySet){
//             System.out.println(genre.get(a));
//         }
        
//         for(List<Music> a: musics.values()){
//             for(Music m: a){
//                 System.out.println(m.index + " " + m.playCount);
//             }
//             System.out.println();
//         }
        
//         return answer;
    }
    
    class Music{
        public int playCount;
        public int index;
        
        public Music(int playCount, int index){
            this.playCount = playCount;
            this.index = index;
        }
    }
}