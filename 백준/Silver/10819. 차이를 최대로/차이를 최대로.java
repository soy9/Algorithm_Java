import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] arr, tmp;
	static int N, cnt;
	static boolean visited[];
	static int maxSum = Integer.MIN_VALUE;

	static void func(int d, int s) {
		if (d == N) {
			if (maxSum < s) {
				maxSum = s;
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				tmp[d] = arr[i];
				if (d > 0) {
					func(d + 1, s + Math.abs(tmp[d] - tmp[d - 1]));
				} else {
					func(d + 1, 0);
				}
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		tmp = new int[N];
		visited = new boolean[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		func(0, 0);
		System.out.println(maxSum);
	}

}