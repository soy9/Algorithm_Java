#include <bits/stdc++.h>
using namespace std;
int t, m, n, k, x, y, cnt;
int a[50][50];
int visited[50][50];
int dx[4] = { 0, 1, 0, -1};
int dy[4] = { -1, 0, 1, 0};
void dfs(int y, int x){
	visited[y][x] = 1;
	int nx, ny;
	for(int k = 0; k < 4; k++){
		nx = x + dx[k];
		ny = y + dy[k];
		if(nx < 0 || nx >= m || ny < 0 || ny >= n || a[ny][nx] == 0) {
			continue;
		}
		if(visited[ny][nx] == 0){
			dfs(ny, nx);
		}
	}
}
int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> t;
	for(int tc = 0; tc < t; tc++) {
		cin >> m >> n;
		cin >> k;
		
		for(int i = 0; i < k; i++) {
			cin >> x >> y;
			a[y][x] = 1;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(a[i][j] == 1 && !visited[i][j]){
					dfs(i, j);
					cnt++;					
				}
			}
		}
		cout << cnt << "\n";
		
		cnt = 0;
		memset(a, 0, sizeof(a));
		memset(visited, 0, sizeof(visited));
	}
	
	return 0;
}