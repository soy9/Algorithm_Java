import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
		int N = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        long point1 = Integer.parseInt(st.nextToken());
        long point2 = Integer.parseInt(st.nextToken());
        
        long length = Math.abs(point1 - point2);
        
        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            if(a >= point2) {
                point1 = a;
                point2 = b;
                length += Math.abs(point1 - point2);
            } else if(b > point2){
                length += Math.abs(point2 - b);
                point2 = b;
            }
        }

		System.out.println(length);
	}

}