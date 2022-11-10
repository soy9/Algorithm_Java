#include<iostream>
#include<string.h>
using namespace std;

int main(){
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	
	int test_case, T = 10;
	int t, a[8], n, pos;
	bool flag;
	
	for(test_case = 1; test_case <= T; ++test_case){
		cin >> t;
		for(int i = 0; i < 8; i++){
			cin >> a[i];
		}
		pos = 0;
		n = 1;
		flag = true;
		while(flag){
			a[pos] = a[pos] - n;
			if(a[pos] <= 0){
				a[pos] = 0;
				flag = false;
			}
			pos++;
			if(pos >= 8){
				pos = 0;
			}
			
			n++;
			if(n > 5){
				n = 1;
			}
		}
		cout << "\n#" << test_case;
		for(int i = 0; i < 8; i++){
			if(pos >= 8){
				pos = 0;
			}
			cout << " " << a[pos];
			pos++;
		}
		memset(a, 0, sizeof(a));
	}
	return 0;
}