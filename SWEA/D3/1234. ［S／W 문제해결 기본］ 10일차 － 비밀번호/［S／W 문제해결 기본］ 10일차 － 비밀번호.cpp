#include<iostream>
#include<string.h>
#include<vector>
using namespace std;

int main(){
	int test_case, T = 10;
	int len, num;
	vector<int> v;
	
	for(test_case = 1; test_case <= T; ++test_case){
		cin >> len;
		for(int i = 0; i < len; i++){
			scanf("%1d", &num);
			if(v.empty() || v.back() != num){
				v.push_back(num);
			} else{
				v.pop_back();
			}
		}
		
		cout << "\n#" << test_case << " ";
		for(auto it : v){
			cout << it;
		}
		v.clear();
	}
	
	return 0;
}