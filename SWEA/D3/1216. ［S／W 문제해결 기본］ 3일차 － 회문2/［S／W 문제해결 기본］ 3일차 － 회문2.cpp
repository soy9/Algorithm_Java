#include <iostream>
using namespace std;

int main() {
	int test_case, i, j, T = 10, len, n;
	 int pos1, pos2, max, cnt;
	 char word[100][100];
	 bool flag;

	for(test_case = 1; test_case <= T; test_case++) {
		cin >> n;
		for (i = 0; i < 100; i++) {
			for (j = 0; j < 100; j++) {
				cin >> word[i][j];
			}
		}
		cnt = 0;
		for (len = 3; len <= 100; len++) {
			//가로
			flag = 0;
			for (i = 0; i < 100; i++) {
				for (j = 0; j <= 100 - len; j++) {
					pos2 = j + len - 1;
					if (word[i][j] == word[i][pos2]) {
						flag = 0;
						pos1 = j;
						for (; pos1 < pos2; pos1++) {
							if (word[i][pos1] != word[i][pos2]) {
								flag = 1;
								break;
							}
							pos2--;
						}
						if (!flag) {
							max = len;
							break;
						}
					}
				}
				if (!flag) {
					break;
				}
			}
			if (flag) {
				//세로
				for (j = 0; j < 100; j++) {
					for (i = 0; i <= 100 - len; i++) {
						pos2 = i + len - 1;
						if (word[i][j] == word[pos2][j]) {
							flag = 0;
							pos1 = i;
							for (; pos1 < pos2; pos1++) {
								if (word[pos1][j] != word[pos2][j]) {
									flag = 1;
									break;
								}
								pos2--;
							}
							if (!flag) {
								max = len;
								break;
							}
						}
					}
					if (!flag) {
						break;
					}
				}
			}

		}

		cout << "#" << test_case << " " << max << "\n";
	}
	return 0;
}