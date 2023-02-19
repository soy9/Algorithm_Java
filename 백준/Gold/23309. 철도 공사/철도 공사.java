import java.io.*;
import java.util.*;

public class Main {
	static int[] prev = new int[1000001];
	static int[] next = new int[1000001];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int tmp = 0, tmp2 = 0;

		st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		int before = first;
		for (int i = 1; i < N; i++) {
			tmp = Integer.parseInt(st.nextToken());
			next[before] = tmp;
			prev[tmp] = before;
			before = tmp;
		}

		next[before] = first;
		prev[first] = before;

		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			switch (str) {
			case "BN":
				tmp = Integer.parseInt(st.nextToken());
				tmp2 = Integer.parseInt(st.nextToken());

				sb.append(next[tmp] + "\n");

				prev[next[tmp]] = tmp2;
				prev[tmp2] = tmp;
				next[tmp2] = next[tmp];
				next[tmp] = tmp2;
				break;
			case "BP":
				tmp = Integer.parseInt(st.nextToken());
				tmp2 = Integer.parseInt(st.nextToken());

				sb.append(prev[tmp] + "\n");

				next[prev[tmp]] = tmp2;
				prev[tmp2] = prev[tmp];
				prev[tmp] = tmp2;
				next[tmp2] = tmp;
				break;
			case "CN":
				tmp = Integer.parseInt(st.nextToken());

				int delNext = next[tmp];
				sb.append(delNext + "\n");

				prev[next[delNext]] = tmp;
				next[tmp] = next[delNext];

				next[delNext] = 0;
				prev[delNext] = 0;
				break;
			case "CP":
				tmp = Integer.parseInt(st.nextToken());

				int delPrev = prev[tmp];
				sb.append(delPrev + "\n");
				next[prev[delPrev]] = tmp;
				prev[tmp] = prev[delPrev];

				next[delPrev] = 0;
				prev[delPrev] = 0;

				break;
			}
		}

		System.out.println(sb);

	}
}