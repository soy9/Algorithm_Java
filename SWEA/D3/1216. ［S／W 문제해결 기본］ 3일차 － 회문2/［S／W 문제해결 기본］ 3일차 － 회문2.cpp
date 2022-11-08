#include<iostream>
#include <algorithm>
#include<vector>
#include<string.h>
#include <stack>

using namespace std;

string a[100];

bool horTest(int l){
	bool flag;
	int mid = l / 2;
	int k, s;
	for(int y = 0; y < 100; y++){
		flag = 0;
		for(int x = 0; x <= 100 - l; x++){
			stack<char> st;
			flag = 0;
			for(k = 0; k < mid; k++){
				st.push(a[y][x + k]);
			}
			s = x + mid;
			if(l % 2 == 1){
				s++;
			}
			for(k = 0; k < mid; k++){
				if(st.top() != a[y][s + k]){
					flag = 1;
					break;
				}
				st.pop();
			}
			if(flag == 0){
				return true;
			} 
		}
	}
	return false;
}
bool verTest(int l){
	bool flag;
	int mid = l / 2;
	int k, s;
	
	for(int x = 0; x < 100; x++){
		flag = 0;
		for(int y = 0; y <= 100 - l; y++){
			stack<char> st;
			flag = 0;
			for(k = 0; k < mid; k++){
				st.push(a[y + k][x]);
			}
			s = y + mid;
			if(l % 2 == 1){
				s++;
			}
			for(k = 0; k < mid; k++){
				if(st.top() != a[s + k][x]){
					flag = 1;
					break;
				}
				st.pop();
			}
			if(flag == 0){
				return true;
			}
		}
	}
	return false;
}
int main(){
	int test_case;
	int T = 10;
	int ret[100];
	int n;
	
	for(test_case = 1; test_case <= T; ++test_case){
		int len = 1;
		cin >> n;
		for(int i = 0; i < 100; i++){
			cin >> a[i];
		}
		for(int i = 3; i < 100; i++){
			if(horTest(i) || verTest(i)){
				len = max(i, len);
			}
		}
		ret[test_case - 1] = len;
		for(int i = 0; i < 100; i ++){
			a[i] = '\n';
		}
	}
	
	for(test_case = 1; test_case <= T; test_case++){
		cout << "#" << test_case << " " << ret[test_case - 1] <<"\n";
	}
	
	return 0;
}