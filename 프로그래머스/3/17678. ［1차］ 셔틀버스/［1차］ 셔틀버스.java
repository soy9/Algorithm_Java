import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {        
        List<Integer> times = new ArrayList<>();
        
        for(String time : timetable) {
            String[] tmp = time.split(":");
            int hour = Integer.parseInt(tmp[0]);
            int min = Integer.parseInt(tmp[1]);
            
            times.add(hour * 60 + min);
        }
        Collections.sort(times);
        
        int crewIdx = 0;
        int shuttleTime = 9 * 60; // 09:00
        int lastTime = 0;
        
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            while(cnt < m && crewIdx < times.size() && times.get(crewIdx) <= shuttleTime) {
                cnt++;
                crewIdx++;
            }
            
            if(i == n - 1) {
                if(cnt < m) {
                    lastTime = shuttleTime;
                } else {
                    lastTime = times.get(crewIdx - 1) - 1;
                }
            }
            shuttleTime += t;
        }
        
        int hour = lastTime / 60;
        int min = lastTime % 60;
        
        return String.format("%02d:%02d", hour, min);
    }
}