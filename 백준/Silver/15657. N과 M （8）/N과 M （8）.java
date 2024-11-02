import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num; // 입력받은 문자열
	static boolean[] checked;
	static int[] arr; // sb대체
	static StringBuilder sb = new StringBuilder();
	static int n, m;

	static void sort() {
		int tmp = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (num[j] < num[i]) {
					tmp = num[i];
					num[i] = num[j];
					num[j] = tmp;
				}
			}
		}
	}

	static void permu(int m, int idx) {

		if (m == 0) {
			sb.append(num[arr[1] - 1]);
			for (int i = 2; i < idx + 1; i++) {
				if (arr[i - 1] > arr[i]) {
					sb.setLength(0);
					return;
				}
				sb.append(" ");
				sb.append(num[arr[i] - 1]);

			}
			System.out.println(sb.toString());
			sb.setLength(0);
			return;
		} else {
			for (int i = 1; i < n + 1; i++) {
				arr[idx + 1] = i;
				permu(m - 1, idx + 1);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		num = new int[n + 1];
		arr = new int[m + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		sort();

		checked = new boolean[n + 1];
		permu(m, 0);

	}

}
