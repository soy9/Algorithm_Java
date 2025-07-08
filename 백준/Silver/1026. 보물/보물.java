import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int N = Integer.parseInt(br.readLine());

		int[] A = new int[N];
        int[] B = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        // input end
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        for(int i = 0; i < N; i++) {
            answer += A[i] * B[N - 1 - i];
        }
        
		
		System.out.println(answer);

	}
}