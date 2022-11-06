#include<iostream>
#include <algorithm>
#include<vector>
#include<string.h>

using namespace std;

int main(){
	int test_case, t;
	int T = 10;
	int ret[10];
	int cnt = 0;
	
	for(test_case = 1; test_case <= T; ++test_case){
        string str, stc;
		int pos = 0;
		cin >> t;
		cin >> str;
		cin >> stc;
		cnt = 0;		
		while(stc.find(str, pos) != string::npos){
			cnt++;
			pos = stc.find(str, pos) + str.size(); 
		}
		ret[test_case - 1] = cnt;
	}
	for(test_case = 1; test_case <= 10; test_case++){
		cout << "#" << test_case << " " << ret[test_case - 1] <<"\n";
	}
	
	return 0;
}