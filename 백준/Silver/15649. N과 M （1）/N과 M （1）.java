import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] checked;
	static StringBuilder sb = new StringBuilder();

	static void permu(int n, int m) {

		if (m == 0) {
			System.out.println(sb.toString());
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				if (!checked[i]) {
					checked[i] = true;
					sb.append(Integer.toString(i));
					sb.append(" ");
					permu(n, m - 1);
					sb.setLength((sb.length() - 2));
					checked[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		checked = new boolean[n + 1];

		permu(n, m);

	}

}
