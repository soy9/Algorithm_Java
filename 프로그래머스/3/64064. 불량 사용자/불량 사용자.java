import java.util.*;

class Solution {
    boolean[] visited = null;
    ArrayList[] list = null;
    Set<String> set = new HashSet<>();
    int[] arr= null;
    
    void dfs(int n, int cnt, int len) {
        if(cnt == len) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < cnt; i++) {
                pq.add(arr[i]);
            }
            
            String s = "";
            while(!pq.isEmpty()) {
                s += pq.poll() + " ";
            }
            
            set.add(s);
            return;
        }
        
        
        for(int i = 0; i < list[n].size(); i++) {
            Integer idx = (Integer)list[n].get(i);
            if(!visited[idx]) {
                visited[idx] = true;
                arr[cnt] = idx;
                dfs(n + 1, cnt + 1, len);
                visited[idx] = false;
            }
        }
    }
    
    
    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];
        list = new ArrayList[banned_id.length];
        arr = new int[banned_id.length];
        
        for(int i = 0; i < banned_id.length; i++) {
            list[i] = new ArrayList<Integer>();
            
            for(int j = 0; j < user_id.length; j++) {
                
                if(banned_id[i].length() == user_id[j].length()) {
                    boolean flag = true;
                    
                    for(int k = 0; k < banned_id[i].length(); k ++) {
                        char c = banned_id[i].charAt(k);
                        
                        if(c != user_id[j].charAt(k) && c != '*') {
                            flag = false;
                            continue;
                        }
                    }
                    
                    if(flag) {
                        list[i].add(j);
                    }
                }
            }
        }
        
        dfs(0, 0, banned_id.length);
        
        return set.size();
    }
}