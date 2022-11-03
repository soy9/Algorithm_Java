#include <bits/stdc++.h>
using namespace std;
int n;
string s;
vector <string> v;
bool cmp(string a, string b){
	if(a.size() == b.size()){
		return a < b;
	}
	return a.size() < b.size();
}
int main(){
	ios::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
	cin >> n;
	
	for(int i = 0; i < n; i++) {
			cin >> s;
		for(int j = 0; j < s.size(); ){
			if(s[j] < '0' || s[j] > '9'){
				j++;
			} else{
				int tmp = 0;
				for(int k = j; k < s.size(); k++){
					if(s[k] < '0' || s[k] > '9'){
						break;
					} else{
						tmp++;
					}
				} 
				string num = s.substr(j, tmp);
				if(num[0] == '0' && num.size() > 1){
					bool flag = 0;
					for(int k = 0; k < num.size(); k++){
						if(k > 0 && num[k] != '0') {
							flag = 1;
							v.push_back(num.substr(k));
							
							break;
						}
					}
					if(!flag) {
						v.push_back(num.substr(0, 1));
					}
				} else{
					v.push_back(num);
				}
				j = j + tmp;
			}
		}
	}
	sort(v.begin(), v.end(), cmp);
	for(auto it : v) {
		cout << it << "\n";
	}
	return 0;
}