import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	static void permu(int s, int r) {
		if (r == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = s; i < N; i++) {
			arr[r] = i + 1;
			permu(i, r + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		permu(0, 0);

		System.out.println(sb);

	}

}