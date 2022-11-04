#include<bits/stdc++.h>
using namespace std;
int h, w;
string m[104];
int a[104][104];
int main(){
	cin >> h >> w;
	for(int i = 0; i < h; i ++){
		cin >> m[i];
	}
	for(int i = 0; i < h; i++){
		bool meet = false;
		for(int j = 0; j < w;){
			if(m[i][j] == '.' && !meet){
				a[i][j] = -1;
				j++;
			}else{
				meet = true;
				if(j + 1 < w) {
					int tmp = j + 1;
					for(int k = tmp; k < w; k++){
						if(m[i][k] == '.'){
							a[i][k] = a[i][k - 1] + 1;
						} else {
							tmp = k;
							break;
						}
					}
					j = tmp;
				} else{
					j++;
				}
			}
		}
	}
	
	for(int i = 0; i < h; i ++){
		for(int j = 0; j < w; j++){
			cout << a[i][j] << " ";
		}
		cout << "\n";
	}
	return 0;
}