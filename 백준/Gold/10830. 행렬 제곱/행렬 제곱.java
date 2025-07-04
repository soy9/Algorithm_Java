import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = power(A, B);

        for (int[] row : result) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 행렬 제곱
    static int[][] power(int[][] matrix, long exp) {
        if (exp == 1L) return matrix;

        int[][] half = power(matrix, exp / 2);
        int[][] result = multiply(half, half);

        if (exp % 2 == 1) {
            result = multiply(result, matrix);
        }

        return result;
    }

    // 행렬 곱
    static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j];
                    sum %= MOD; // 곱셈 이후 모듈러 처리
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}
