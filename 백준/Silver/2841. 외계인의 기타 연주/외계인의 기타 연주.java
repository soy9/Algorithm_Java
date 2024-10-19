import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N, P;
		int cnt = 0;
		Stack<Integer>[] stack = new Stack[7];

		for (int i = 1; i <= 6; i++) {
			stack[i] = new Stack<>();
		}

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (stack[s].isEmpty()) {
				stack[s].push(p);
				cnt++;
			} else if (stack[s].peek() < p) { // 새로운게 더 높은 경우
				stack[s].push(p);
				cnt++;
			} else if (stack[s].peek() > p) { // 기존게 높은 경우
				while (!stack[s].isEmpty() && stack[s].peek() > p) {
					stack[s].pop();
					cnt++;
				}
				if (stack[s].isEmpty() || (!stack[s].isEmpty() && stack[s].peek() < p)) {
					stack[s].push(p);
					cnt++;
					continue;
				}
			}
		}
		System.out.println(cnt);

	}
}
