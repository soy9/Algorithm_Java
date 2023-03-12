import java.util.*;

class Solution {
    boolean[] visited;
	int[] num;
	Set<Integer> numSet = new HashSet<Integer>();

	public int solution(String numbers) {
		num = new int[numbers.length()];
		visited = new boolean[numbers.length()];

		for (int i = 0; i < numbers.length(); i++) {
			num[i] = (int) numbers.charAt(i) - '0';
		}
		for (int i = 1; i <= numbers.length(); i++) {
			permu(i, 0, 0, numbers.length());
		}
		int answer = 0;
		for (Integer n : numSet) {
			if (isPrime(n)) {
				answer++;
			}
		}
		return answer;
	}

	void permu(int r, int d, int n, int len) {
		if (d == r) {
			numSet.add(n);
			return;
		}
		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int tmp = (n * 10) + num[i];
				permu(r, d + 1, tmp, len);
				visited[i] = false;
			}
		}
	}

	boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}