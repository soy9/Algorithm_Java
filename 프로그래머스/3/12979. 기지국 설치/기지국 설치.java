class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int r = 2 * w + 1;
        int len = 0;
        
        // 왼쪽
        len = stations[0] - w - 1;
        if(len > 0) {
            answer += len / r;
            if(len % r != 0) {
                answer++;
            }            
        }
        // 오른쪽
        if(stations[stations.length - 1] + w < n) {
            len = n - (stations[stations.length - 1] + w);
            answer += len / r;
            if(len % r != 0) {
                answer++;
            }
        }

        if(stations.length > 1) {
            for(int i = 0; i < stations.length - 1; i++){
                if(stations[i + 1] - stations[i] - r <= 0) {
                    continue;
                }
                len = stations[i + 1] - stations[i] - r;
                answer += len / r;
                if(len % r != 0) {
                    answer++;
                }
            }
        }
        

        return answer;
    }
}