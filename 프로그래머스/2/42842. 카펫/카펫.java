class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row = 0, col = 0;
        
        int l = (brown - 4) / 2;
        
        row = (l % 2 == 0) ? l / 2 : (l / 2) + 1;
        col = l - row;
        
        while(col <= row) {
            if(col * row == yellow) {
                break;
            }
            row++;
            col = l - row;
        }
        
        answer[0] = row + 2;
        answer[1] = col + 2;
        
        return answer;
    }
}