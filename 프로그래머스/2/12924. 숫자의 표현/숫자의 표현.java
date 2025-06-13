class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 1, end = 1, sum = 1;

        while (start <= n / 2) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                answer++;
                sum -= start;
                start++;
            }
        }

        return answer + 1; // 자기 자신 1개도 포함
    }
}