import java.io.*;
import java.util.*;

public class Main {
	static int L, C;
	static String[] alpha;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static void dfs(int d, int s) {
		if (d == L) {
			int v = 0, u = 0;
			String str = "";
			for (int i = 0; i < C; i++) {
				if (visited[i]) {
					str += alpha[i];
					if (alpha[i].equals("a") || alpha[i].equals("e") || alpha[i].equals("i") || alpha[i].equals("o")
							|| alpha[i].equals("u")) {
						v++;
					} else {
						u++;
					}
				}
			}

			if (v > 0 && u > 1) {
				sb.append(str + "\n");
			}
			return;
		}

		for (int i = s; i < C; i++) {
			visited[i] = true;
			dfs(d + 1, i + 1);
			visited[i] = false;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpha = new String[C];
		visited = new boolean[C];
		alpha = br.readLine().split(" ");

		Arrays.sort(alpha);
		dfs(0, 0);
		
		System.out.println(sb);

	}
}