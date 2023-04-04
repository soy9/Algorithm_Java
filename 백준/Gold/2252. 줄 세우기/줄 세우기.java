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
        // input end

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			if (in[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int idx = q.poll();
			sb.append((idx + 1) + " ");
			for (Integer next : student[idx]) {
				in[next]--;
				if (in[next] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(sb);

	}
}