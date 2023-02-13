import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Stack<Integer> stack = new Stack<>();
	static int[] arr;

	public static void NGE() {
		for (int i = 0; i < N; i++) {
			while (true) {
				if (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
					arr[stack.pop()] = arr[i];
				} else {
					break;
				}
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		NGE();

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}
