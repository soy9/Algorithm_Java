import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] in = new int[N];
		boolean[] visited = new boolean[N];
		Arrays.fill(visited, false);
		List<Integer>[] student = new List[N];
		for (int i = 0; i < N; i++) {
			student[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			student[from - 1].add(to - 1);
			in[to - 1]++;
		}
		M = N;

		while (N > 0) {
			for (int i = 0; i < M; i++) {
				if (in[i] == 0 && !visited[i]) {
					visited[i] = true;
					sb.append((i + 1) + " ");
					for (Integer next : student[i]) {
						in[next]--;
					}
					N--;
				}
			}
		}

		System.out.println(sb);

	}
}