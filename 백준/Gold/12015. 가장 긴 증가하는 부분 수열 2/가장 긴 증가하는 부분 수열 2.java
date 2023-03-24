import java.util.*;
import java.io.*;

class Main {
	static int N;
	static int[] inputs;
	static int[] res;

	static void binarySearch(int now, int resLen) {
		int mid = resLen / 2;
		int low = 0;
		int high = resLen;

		while (low <= high) {
			mid = (low + high) / 2;

			if (low == high) {
				break;
			}

			if (res[mid] == inputs[now]) {
				return;
			} else if (res[mid] > inputs[now]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		if (res[mid] < inputs[now]) {
			res[mid + 1] = inputs[now];
		} else if (res[mid] > inputs[now]) {
			res[mid] = inputs[now];
		} 

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		inputs = new int[N];
		res = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}

		int resLen = 0;
		res[0] = inputs[0];
		for (int i = 1; i < N; i++) {
			if (inputs[i] > res[resLen]) { // 큰 수이면 뒤에 붙인다.
				res[++resLen] = inputs[i];
			} else if (inputs[i] < res[resLen]) {
				binarySearch(i, resLen + 1);
			}
		}

		System.out.println(resLen + 1);
	}
}