import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String, Integer> playsSum = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> musicInfo = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            
            if(!playsSum.containsKey(genres[i])) {
                playsSum.put(genres[i], plays[i]);
                
                HashMap<Integer, Integer> mi = new HashMap<>();
                mi.put(i, plays[i]);
                musicInfo.put(genres[i], mi);
                
            } else {
                playsSum.put(genres[i], playsSum.get(genres[i]) + plays[i]);
                musicInfo.get(genres[i]).put(i, plays[i]);
            }
        }
        
        // 내림차순 정렬
        List<String> keySet = new ArrayList(playsSum.keySet());
        Collections.sort(keySet, (s1, s2) -> playsSum.get(s2) - playsSum.get(s1));
        
        for(String key : keySet) {
            HashMap<Integer, Integer> music = musicInfo.get(key);
            
            List<Integer> musicKey = new ArrayList(music.keySet());
            Collections.sort(musicKey, (s1, s2) -> music.get(s2) - music.get(s1));
            
            answer.add(musicKey.get(0));
            if(musicKey.size() > 1) {
                answer.add(musicKey.get(1));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}