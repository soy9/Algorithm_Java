import java.util.*;

class Solution {
    int minTrans = 50;
    boolean[] visited = null;
    List<Integer>[] list = null;
    
    void dfs (int idx, int targetIdx, int l) {
        if(idx == targetIdx) {
            minTrans = (l < minTrans) ? l : minTrans;
            return;
        }
        
        ListIterator<Integer> iter = list[idx].listIterator();
        
        while(iter.hasNext()) {
            int i = iter.next();
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, targetIdx, l + 1);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetIdx = -1;
        int len = begin.length();
        visited = new boolean[words.length];
        list = new LinkedList[words.length + 1];
        
        list[words.length] = new LinkedList<>();
        for(int i = 0; i < words.length; i++) {
            list[i] = new LinkedList<>();
            if(words[i].equals(target)) {
                targetIdx = i;
            }
            int diff = 0;
            for(int k = 0; k < len; k++) {
                if(begin.charAt(k) != words[i].charAt(k)) {
                    diff++;
                }
            }
            if(diff == 1) {
                list[words.length].add(i);
            }
        }
        
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                int diff = 0;
                for(int k = 0; k < len; k++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) {
                        diff++;
                    }
                }
                if(diff == 1) {
                    list[i].add(j);
                    list[j].add(i);
                }
            }
        }
        
        if(targetIdx >= 0) {
            dfs(words.length, targetIdx, 0);
            answer = minTrans;
        }
        
        return answer;
    }
}