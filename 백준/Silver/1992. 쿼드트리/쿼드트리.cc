#include <bits/stdc++.h>
using namespace std;
int n, a[65][65];

void quadTree(int len, int x, int y) {
	int tmp = a[y][x];
	int nx, ny;
	if(len == 1) {
		cout << tmp;
		return;
	}
	for(int i = 0; i < len; i++){
		ny = y + i;
		for(int j = 0; j < len; j++){
			nx = x + j;
			if(a[ny][nx] != tmp){
				cout << "(";
				quadTree(len / 2, x, y);
				quadTree(len / 2, x + (len / 2), y);
				quadTree(len / 2, x, y + (len / 2));
				quadTree(len / 2, x + (len / 2), y + (len / 2));
				cout << ")";
				return;
			}
		}
	}
	cout << tmp;
}

int main(){
	cin >> n;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			scanf("%1d", &a[i][j]);
		}
	}
	quadTree(n, 0, 0);
	
	return 0;
}