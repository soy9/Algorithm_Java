class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int rival1 = Math.min(a, b);
        int rival2 = Math.max(a, b);
        
        boolean [] isRival = new boolean[n + 1];
        isRival[a] = isRival[b] = true;
        
        while(true) {
            rival1 = (rival1 % 2 == 0) ? rival1 : rival1 + 1;
            rival2 = (rival2 % 2 == 0) ? rival2 : rival2 + 1;
            
            rival1 /= 2;
            rival2 /= 2;
            
            if(rival1 == rival2) {
                break;
            }
            answer ++;
        }
        
        return answer;
    }
}