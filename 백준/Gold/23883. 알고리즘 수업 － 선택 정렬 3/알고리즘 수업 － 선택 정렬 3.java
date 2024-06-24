import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        TreeMap<Integer, Integer> idxMap = new TreeMap<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            idxMap.put(val, i);
        }

        // selection sort
        int times = 0, i = N;
        for(Integer key : idxMap.keySet()) {
            if(arr[i] != key) {
                if(++times == K) {
                    System.out.println(arr[i] + " " + arr[idxMap.get(key)]);
                    break;
                }
                int idx = idxMap.get(key);
                arr[idx] = arr[i];

                idxMap.replace(arr[idx], idx);

            }
            i--;
        }

        if(times < K) {
            System.out.println("-1");
        }
    }
}