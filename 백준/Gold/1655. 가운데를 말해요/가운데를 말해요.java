import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N, x;
		PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>();

		N = Integer.parseInt(br.readLine());

		x = Integer.parseInt(br.readLine());
		priorityQueue1.add(x);
		sb.append(priorityQueue1.peek() + "\n");

		for (int i = 1; i < N; i++) {
			x = Integer.parseInt(br.readLine());

			priorityQueue2.add(x);
			
			if (i % 2 == 0) {
				priorityQueue1.add(priorityQueue2.poll());
			} else if (priorityQueue1.peek() > priorityQueue2.peek()) {
				int tmp = priorityQueue1.poll();
				priorityQueue1.add(priorityQueue2.poll());
				priorityQueue2.add(tmp);
			}

			sb.append(priorityQueue1.peek() + "\n");
		}
		System.out.println(sb);
	}

}
