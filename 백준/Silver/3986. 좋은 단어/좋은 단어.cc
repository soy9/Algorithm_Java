#include <bits/stdc++.h>
using namespace std;
int n, cnt;
string s;

int main() {
	cin >> n;
	
	for(int i = 0; i < n; i++) {
		cin >> s;
		stack<char> st;
		
		for(int j = 0; j < s.size(); j++) {
			if(!st.empty() && st.top() == s[j]) {
				st.pop();
			} else {
				st.push(s[j]);
			}
		}
			
		if(st.empty()) {
			cnt ++;
		}
	}
	
	cout << cnt << "\n";
	
	return 0;
}