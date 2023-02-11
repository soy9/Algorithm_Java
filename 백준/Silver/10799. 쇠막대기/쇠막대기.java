import java.io.*;
import java.util.*;

public class Main {
	static String str;
	static Stack<Integer> stack = new Stack<>();

	public static int stick() {
		boolean flag = false;
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(1);
				flag = true;
			} else if (flag) { // 전에 ( 였다
				stack.pop();
				cnt += stack.size();
				flag = false;
			} else { // 전에 ) 였다
				stack.pop();
				cnt += 1;
				flag = false;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		System.out.println(stick());
	}
}
