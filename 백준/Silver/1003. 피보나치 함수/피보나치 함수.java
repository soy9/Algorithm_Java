import java.io.*;
import java.util.*;

public class Main {    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        int[][] cnt = new int[41][2];
         cnt[0][0] = 1;
         cnt[1][1] = 1;
        
        int lastIdx = 1;
        
        for(int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            
            if(N > lastIdx) {
                for(int n = lastIdx + 1; n <= N; n++) {
                    cnt[n][0] = cnt[n - 1][0] + cnt[n - 2][0];
                    cnt[n][1] = cnt[n - 1][1] + cnt[n - 2][1];
                }
            }
            
            sb.append(cnt[N][0]).append(" ");
            sb.append(cnt[N][1]).append("\n");
        }
        
		System.out.println(sb);
	}
    
}