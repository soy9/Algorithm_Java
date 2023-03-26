import java.util.*;
import java.io.*;

class Main {

	static class Person implements Comparable<Person> {
		int age;
		int n;
		String name;

		public Person(int age, int n, String name) {
			super();
			this.age = age;
			this.n = n;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			if (this.age == o.age) {
				return Integer.compare(this.n, o.n);
			}
			return Integer.compare(this.age, o.age);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		List<Person> people = new LinkedList<Person>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people.add(new Person(age, i, name));
		}
		
		Collections.sort(people);
		
		for(Person p : people) {
			sb.append(p.age + " " + p.name + "\n");
		}
		System.out.println(sb);
	}
}