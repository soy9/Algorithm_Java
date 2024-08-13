class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int x = 0, y = 0;
        int xlen = park[0].length();
        int ylen = park.length;
        
        boolean[][] isAvaiable = new boolean[xlen][ylen];
        
        for(int i = 0; i < ylen; i++) {
            String[] parkInfo = park[i].split("");
        
            for(int j = 0; j < xlen; j++) {
                if(parkInfo[j].equals("S")) {
                    x = j;
                    y = i;
                    isAvaiable[j][i] = true;
                } else if(parkInfo[j].equals("O")) {
                    isAvaiable[j][i] = true;
                }
            }
        }
        
        for(String route : routes) {
            String[] info = route.split(" ");
            
            // 방향 가중치
            int dx = 0;
            int dy = 0;
            if(info[0].equals("N")){  
                dy = -1;
            } else if(info[0].equals("S")){
                dy = 1;
            } else if(info[0].equals("W")){
                dx = -1;
            } else {
                dx = 1;
            }
            
            int times = Integer.parseInt(info[1]);
            
            int nx = x;
            int ny = y;
            boolean flag = true;
            while(times-- > 0) {
                nx += dx;
                ny += dy;
                if(nx < 0 || nx >= xlen || ny < 0 || ny >= ylen || !isAvaiable[nx][ny]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                x = nx;
                y = ny;
            }
        }
        answer[0] = y;
        answer[1] = x;
        
        return answer;
    }
}