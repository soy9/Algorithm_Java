class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int sum = 0;
        int n = 0;
        for(int num : arr) {
            sum += num;
            n++;
        }
        answer = (double) sum / n;
        return answer;
    }
}