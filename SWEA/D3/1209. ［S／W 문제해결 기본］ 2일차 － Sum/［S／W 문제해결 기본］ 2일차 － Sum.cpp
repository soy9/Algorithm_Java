#include <iostream>
using namespace std;

int main() {
	 int test_case, i, j,  T = 10, n;
	 int arr[104][104] = { 0, }, ret,max, sum, sum2;

	for (test_case = 1; test_case <= T; test_case++) {
		cin >> n;
		max = 0;
		for (i = 0; i < 100; i++) {
			sum = 0;
			for (j = 0; j < 100; j++) {
				cin >> arr[i][j];
				sum += arr[i][j];
			}
			if (sum > max) {
				max = sum;
			}
		}

		//vertical sum
		for (j = 0; j < 100; j++) {
			sum = 0;
			for (i = 0; i < 100; i++) {
				sum += arr[i][j];
			}
			if (sum > max) {
				max = sum;
			}
		}

		sum = sum2 = 0;
		j = 99;
		for (i = 0; i < 100; i++) {
			sum += arr[i][i];
			sum2 += arr[i][j];
			j--;

		}
		if (sum > max) {
			max = sum;
		}
		if (sum2 > max) {
			max = sum2;
		}

		cout << "#" << n << " " << max << "\n";
	}
	return 0;
}