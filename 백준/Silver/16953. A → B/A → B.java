import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

        int steps = 1;
        
        // B(목표)를 A로 만들기
		while(A < B) {
            if(B % 10 == 1) {
                B /= 10;
            } else if(B % 2 == 0) {
                B /= 2;
            } else {
                break;
            }
            
            steps++;
        }
		
		System.out.println((A == B) ? steps : -1);
	}
}