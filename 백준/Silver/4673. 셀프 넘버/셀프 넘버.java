import java.util.*;

public class Main {

	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
        
		boolean[] isSelfNum = new boolean[10001];
        boolean[] visited = new boolean[10001];
        Arrays.fill(isSelfNum, true);
        
		for (int i = 1; i <= 10000; i++) {
			if(isSelfNum[i]) {
                sb.append(i).append("\n");
            }
            if(visited[i]) {
                continue;
            }
            visited[i] = true;
            int num = i;
            while(num <= 10000) {
                // 각 자리수 더하기
                int remain = num;
                int sum = 0;
                while(remain > 0) {
                    sum += remain % 10;
                    remain /= 10;
                }
                num += sum;
                if(num > 10000) {
                    break;
                }
                isSelfNum[num] = false;
                visited[num] = true;
            }
		}

		System.out.println(sb);
	}

}