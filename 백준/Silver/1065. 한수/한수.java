import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		int dif = 0;

		int n = Integer.parseInt(br.readLine());
		if (n > 99) {
			cnt = 99;

			for (int i = 100; i <= n; i++) {
				boolean flag = true;
				String[] num = Integer.toString(i).split("");
				dif = Integer.parseInt(num[0]) - Integer.parseInt(num[1]);
				for (int j = 1; j < num.length - 1; j++) {
					if (dif != Integer.parseInt(num[j]) - Integer.parseInt(num[j + 1])) {
						flag = false;
						break;
					}
				}
				if (flag) {
					cnt++;
				}
			}
		} else {
			cnt = n;
		}

		System.out.println(cnt);

	}

}
