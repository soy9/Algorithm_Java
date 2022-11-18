#include <iostream>
using namespace std;

int main() {
	int test_case, i, j, k, T = 10, len;
	 int pos1, pos2;
	 char word[8][8];
	 int cnt;
	 bool flag;

	for(test_case = 1; test_case <= T; test_case++) {
		cin >> len;
		for (i = 0; i < 8; i++) {
			for (j = 0; j < 8; j++) {
				cin >> word[i][j];
			}
		}
		cnt = 0;
		//hor
		for (i = 0; i < 8; i++) {
			for (j = 0; j <= 8 - len; j++) {
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
						cnt++;
					}
				}
			}
		}
		//ver
		for (j = 0; j < 8; j++) {
			for (i = 0; i <= 8 - len; i++) {
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
						cnt++;
					}
				}
			}
		}

		cout << "#" << test_case << " " << cnt << "\n";
	}
	return 0;
}