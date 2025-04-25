class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        
        int len = triangle.length;
        int by, bx, temp;
        
        int[][] psum = new int[len][len];
        psum[0][0] = triangle[0][0];
        
        for(int y = 1; y < len; y++) {
            by = y - 1;
            for(int x = 0; x <= y; x++) {
                temp = 0;
                for(int i = -1; i <= 0; i++) {
                    bx = x + i;
                    if(bx < 0) {
                        continue;
                    }
                    temp = Math.max(temp, psum[by][bx]);
                }
                psum[y][x] = temp + triangle[y][x];
                answer = Math.max(answer, psum[y][x]);
            }
        }
        
        return answer;
    }
}