import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] arr = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sum = 0;
		int s = 0, e = 0;
		int minLen = Integer.MAX_VALUE;
		int len = 0;

		while (e <= N) {
			if (sum >= S) {
				sum -= arr[s++];
				len = e - s + 1;
				if (minLen > len) {
					minLen = len;
				}
			} else {
				sum += arr[e++];
			}
		}
		minLen = (minLen == Integer.MAX_VALUE) ? 0 : minLen;
		System.out.println(minLen);
	}
}