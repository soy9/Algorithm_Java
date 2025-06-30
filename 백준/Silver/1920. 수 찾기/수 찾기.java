import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
		int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            boolean isExist = binarySearch(n, arr);
            System.out.println(isExist ? 1 : 0);
        } 
        
	}
    
    static boolean binarySearch(int n, int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;
       
        while(first <= last) {
            mid = (first + last) / 2;
        
            if(arr[mid] == n) {
                return true;
            } else if (arr[mid] > n) {
                last = mid - 1;
            } else{
                first = mid + 1;
            } 
        }
        
        return false;
    }

}