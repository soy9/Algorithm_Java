class Solution {
    public int solution(int[] numbers) {
        int answer = 9 * 10 / 2;
        for(int num : numbers) {
            answer -= num;
        }
        return answer;
    }
}