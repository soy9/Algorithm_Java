import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.containsKey(key)) {
				map.replace(key, map.get(key )+ 1);
			} else {
				map.put(key, 1);
			}
		}

		ArrayList<Integer> keylist = new ArrayList<Integer>(map.keySet());
		Collections.sort(keylist, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(map.get(o2), map.get(o1));
			}

		});

		for (Integer n : keylist) {
			for (int i = 0; i < map.get(n); i++) {
				sb.append(n).append(" ");
			}
		}
		System.out.println(sb);
	}

}