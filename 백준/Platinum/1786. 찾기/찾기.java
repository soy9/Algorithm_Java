import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] T = br.readLine().toCharArray();
		char[] R = br.readLine().toCharArray();
        
		int[] table = new int[R.length];
		// 1. R문자열의 접두사 접미사 구하기
		int j = 0;
		for (int i = 1; i < R.length; i++) {
			while (j > 0 && R[i] != R[j]) {
				j = table[j - 1];
			}
			if (R[i] == R[j]) {
				table[i] = ++j;
			}
		}

		// 2. KMP
		j = 0;
		int cnt = 0;
		for (int i = 0; i < T.length; i++) {
			while (j > 0 && T[i] != R[j]) {
				j = table[j - 1];
			}
			if (T[i] == R[j]) {
				if (j == R.length - 1) {
					cnt++;
					sb.append(i - R.length + 2).append(" ");
					j = table[j];
				} else {
					j++;
				}
			}

		}
		System.out.println(cnt);
		System.out.println(sb);

	}
}