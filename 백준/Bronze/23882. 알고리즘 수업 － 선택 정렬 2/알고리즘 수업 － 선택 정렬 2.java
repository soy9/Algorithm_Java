import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // input end

        int max, maxIdx, temp;
        int times = 0;
        for(int i = 0; i < N; i++) {
            int pos = N - i - 1;
            max = arr[pos];
            maxIdx = pos;
            for(int j = pos; j >= 0; j--) {
                if(max < arr[j]) {
                    max = arr[j];
                    maxIdx = j;
                }
            }
            if(maxIdx < pos) {
                temp = arr[pos];
                arr[pos] = arr[maxIdx];
                arr[maxIdx] = temp;

                if(++times == K) break;
            }
        }

        // output
        if(times < K) {
            System.out.println(-1);
        } else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
        }

    }

}