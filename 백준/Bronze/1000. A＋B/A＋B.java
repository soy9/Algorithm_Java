import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		sum += Integer.parseInt(st.nextToken());
		sum += Integer.parseInt(st.nextToken());

		System.out.println(sum);
	}

}