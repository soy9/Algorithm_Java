#include<iostream>
#include<string.h>
#include<vector>
using namespace std;

int main(){
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	
	int test_case, T = 10;
	int len, n, x, y, s, num;
	char c;
	vector<int> v;
	
	for(test_case = 1; test_case <= T; ++test_case){
		cin >> len;
		for(int i = 0; i < len; i++){
			cin >> num;
			v.push_back(num);
		}
		
		cin >> n;	//명령어 개수  
		for(int i = 0; i < n; i++){
			cin >> c;
			if(c == 'I'){
				cin >> x >> y;
				for(int j = 0; j < y; j++){
					cin >> s;
					v.insert(v.begin() + x + j, s);
				}
			} else if (c == 'D'){
				cin >> x >> y;
				v.erase(v.begin() + x - 1, v.begin() + x + y);
			} else if (c == 'A'){
				cin >> y;
				for(int j = 0; j < y; j++){
					cin >> s;
					v.push_back(s);
				}
			}
		}
		cout << "\n#" << test_case;
		for(int i = 0; i < 10; i++){
			cout << " " << v[i];
		}
		v.clear();
	}
	return 0;
}