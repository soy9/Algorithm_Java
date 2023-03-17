import java.util.*;
import java.io.*;

class Main {
	static int N, M;
	static int[] answer;
	static int[] arr;
	static boolean[] check;
	static StringBuilder sb = new StringBuilder();

	static void perm(int d) {
		if (d == M) {
			for (int i = 0; i < M; i++) {
				sb.append(answer[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int before = 0; // 이전에 뽑았던 값을 저장
		for (int i = 0; i < N; i++) {
			if (check[i]) { // 뽑았던 값이면
				continue;
			} else if (before != arr[i]) {
				check[i] = true;
				answer[d] = arr[i];
				before = arr[i];
				perm(d + 1);
				check[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		answer = new int[M];
		check = new boolean[N];
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		perm(0);
		System.out.println(sb);
	}
}