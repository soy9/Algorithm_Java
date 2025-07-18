import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int TC = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<String, Integer>();
            
            for(int i = 0; i < N; i++) {
                String[] str = br.readLine().split(" ");
                
                int cnt = 0;
                if(map.containsKey(str[1])) {
                    cnt = map.get(str[1]);
                }
                
                map.put(str[1], cnt + 1);
            }
            
            int combi = 1;
            for (String key : map.keySet()) {
                combi *= map.get(key) + 1;
            }
            sb.append(combi - 1).append("\n");
        }
        
		System.out.println(sb);

	}
}
