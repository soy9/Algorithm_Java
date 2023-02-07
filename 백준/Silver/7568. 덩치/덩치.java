import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] height;
	static int[] weight;
	static int[] cnt;

	public static void isBig(int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (height[i] > height[j] && weight[i] > weight[j]) {
					cnt[j]++;
				} else if (height[i] < height[j] && weight[i] < weight[j]) {
					cnt[i]++;
				}
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int dif = 0;

		int n = Integer.parseInt(br.readLine());
		height = new int[n];
		weight = new int[n];
		cnt = new int[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}

		isBig(n);

		for (int i = 0; i < n; i++) {
			System.out.print((cnt[i] + 1) + " ");
		}

	}

}
