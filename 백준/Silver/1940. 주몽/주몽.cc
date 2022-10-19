#include <bits/stdc++.h>
using namespace std;
int n, m, cnt;
int v[15000];

int main() {
	cin >> n >> m;
	
	for(int i = 0; i < n; i++){
		cin >> v[i];
	}
	sort(v, v + n);
	
	if(m > 200000){
		cnt = 0;
		cout << cnt <<"\n";
		return 0;
	}
	
	for(int i = 0; i < n; i++){
		for(int j = i + 1; j < n; j++){
			if(v[i] + v[j] == m){
				cnt++;
			}
		}
	}
	cout << cnt <<"\n";
	
	return 0;	
}