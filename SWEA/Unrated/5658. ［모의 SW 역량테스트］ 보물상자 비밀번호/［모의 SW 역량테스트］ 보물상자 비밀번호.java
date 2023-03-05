import java.io.*;
import java.util.*;

public class Solution {

	static int makeNum(int[] num, int tc, int n, int N, int K) {
		int[] arr = new int[N];
		int idx = 0;

		// n = 자릿수
		for (int i = 0; i < N; i++) {
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				int numIdx = i + j;
				if (numIdx >= N) {
					numIdx -= N;
				}
				tmp += num[numIdx] * ((int) Math.pow(16, (n - j - 1)));
			}
			arr[idx] = tmp;
			idx++;
		}
		Arrays.sort(arr);

		if (K == 1) {
			return arr[N - 1];
		}
		int maxCnt = 1;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				maxCnt++;
				if (maxCnt == K) {
//					sb.append("#").append(tc).append(" ").append(arr[i]).append("\n");
					return arr[i];
				}
			}
		}
		return 0;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] num = new int[N];
			String input = br.readLine();
			for (int i = 0; i < N; i++) {
				char c = input.charAt(i);
				switch (c) {
				case '0':
					num[i] = 0;
					break;
				case '1':
					num[i] = 1;
					break;
				case '2':
					num[i] = 2;
					break;
				case '3':
					num[i] = 3;
					break;
				case '4':
					num[i] = 4;
					break;
				case '5':
					num[i] = 5;
					break;
				case '6':
					num[i] = 6;
					break;
				case '7':
					num[i] = 7;
					break;
				case '8':
					num[i] = 8;
					break;
				case '9':
					num[i] = 9;
					break;
				case 'A':
					num[i] = 10;
					break;
				case 'B':
					num[i] = 11;
					break;
				case 'C':
					num[i] = 12;
					break;
				case 'D':
					num[i] = 13;
					break;
				case 'E':
					num[i] = 14;
					break;
				case 'F':
					num[i] = 15;
					break;
				}
			}
			sb.append("#").append(tc).append(" ");
			sb.append(makeNum(num, tc, N / 4, N, K)).append("\n");
		}
		System.out.print(sb);
	}

}