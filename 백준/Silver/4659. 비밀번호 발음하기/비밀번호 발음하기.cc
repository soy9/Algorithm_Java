#include <bits/stdc++.h>
using namespace std;
string s;
char vowel[5] = {'a', 'e', 'i', 'o', 'u'};

bool test1() {
	int vcnt = 0, lcnt = 0;
	bool flag = 0;
	for(int i = 0; i < s.size() ; i++){
		if(s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u') {
			vcnt++;
			lcnt = 0;
			flag = 1;
		}else{
			lcnt++;
			vcnt = 0;
		}
		
		if(i < s.size() - 1 && s[i] == s[i+1]) {
			if(s[i] != 'e' && s[i] != 'o'){
				return false;
			}
		}
		
		if(vcnt == 3 || lcnt == 3){
			return false;
		}
	}
	if(flag){
		return true;
	}else{
		return false;
	}
}
int main() {
	cin >> s;
	while(s != "end"){
		if(test1()) {
			cout << "<" << s << "> is acceptable.\n";
		} else {
			cout << "<" << s << "> is not acceptable.\n";
		}
		s.clear();
		cin >> s;
	}
	return 0;
}