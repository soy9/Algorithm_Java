#include<iostream>
#include<string.h>
using namespace std;

string num[10] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

int main(){
	ios::sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	
	int test_case, T;
	int n, cnt[10];
	string s;
    
	cin >> T;
	for(test_case = 1; test_case <= T; ++test_case){
		memset(cnt, 0, sizeof(cnt));
		cin >> s >> n;
		for(int i = 0; i < n; i++){
			string tmp;
			cin >> tmp;
			for(int j = 0; j < 10; j++){
				if(tmp == num[j]){
					cnt[j]++;
					break;
				}
			}
		}
		cout << "#" << test_case << "\n";
		for(int j = 0; j < 10; j++){
			if(cnt[j] > 0){
				while(cnt[j] > 0){
					cout << num[j] << " ";
					cnt[j]--;
				}
			}
		}
		cout << "\n";
	}
	return 0;
}