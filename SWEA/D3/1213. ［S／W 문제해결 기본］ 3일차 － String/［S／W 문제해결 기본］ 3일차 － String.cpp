#include <iostream>
using namespace std;

int main() {
	 int test_case, i, j,  T = 10, n, len;
	 char sen[1000];
	 char word[10];
	 int cnt;
	 bool flag = 0;

	for (test_case = 1; test_case <= T; test_case++) {
		cin >> n;
		cin >> word;
		cin >> sen;
		
		for (len = 0; word[len] != '\0'; len++){
		}
		i = 0;
		cnt = 0;
		while (sen[i] != '\0') {
			flag = 0;
			if (sen[i] == word[0]) {
				for (j = 0; j < len; j++) {
					if (sen[i + j] != word[j]) {
						flag = 1;
						break;
					}
				}
				if (!flag) {
					cnt++;
					i = i + len - 1;
				}
			} 
			i++;
		}

		cout << "#" << n << " " << cnt << "\n";
	}
	return 0;
}