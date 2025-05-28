import java.io.*;
import java.util.*;

public class Main {
    
    static boolean isPossible(int mid, int[][] arr, String[] s) {
		Map<String, Integer> map = new HashMap<>();
		boolean flag = false;
		for (int i = 0; i < mid; i++) {
			int cnt = 0;
			if(map.containsKey(s[i])) {
				cnt = map.get(s[i]);
			}
			
			map.put(s[i], ++cnt);
			
			if (cnt >= 5) {
				return true;
			}
		}

		for (int i = mid; i < s.length; i++) {
			
			int cnt = map.get(s[i - mid]);
			cnt--;
			map.put(s[i - mid], cnt);
			
			cnt = 0;
			if(map.containsKey(s[i])) {
				cnt = map.get(s[i]);
			}
			cnt++;
			map.put(s[i], cnt);

			if (cnt >= 5) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}

	public static void main(String[] args) throws IOException {
		int answer = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[4][N];
		int[][] temp = new int[4][10];
		boolean canFind = false;

		String[] s = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			
			int j = 0;
			switch(s[i].charAt(1)){
			case 'm':
				j = 0;
				break;
			case 'p':
				j = 1;
				break;
			case 's':
				j = 2;
				break;
			case 'z':
				j = 3;
				break;
			
			}
			arr[j][i] = Integer.parseInt(s[i].charAt(0) + "");

			if (++temp[j][arr[j][i]] >= 5) {
				canFind = true;
			}
		}
		// input end
		
		if (canFind) {
			int min = 5, max = N;

			while (min < max) {
				int mid = (min + max) / 2;
				
				if (isPossible(mid, arr, s)) {
					max = mid;
				} else {
					min = mid + 1;
				}
			}
			answer = min;
		}

		System.out.println(answer);
	}
}