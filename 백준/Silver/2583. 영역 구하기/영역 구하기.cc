#include <bits/stdc++.h>
using namespace std;
int m, n, k, tmp;
int a[101][101], visited[101][101];
int dx[4] = { 0, 1, 0, -1};
int dy[4] = { -1, 0, 1, 0};
vector<int> v;

void bfs(int x, int y) {
	int nx, ny;
	visited[y][x] = 1;
	tmp++;
	for(int i = 0; i < 4; i++) {
		nx = x + dx[i];
		ny = y + dy[i];
		if(nx < 0 || nx >= n || ny < 0 || ny >= m || a[ny][nx] == 1) continue;
		if(a[ny][nx] == 0 && visited[ny][nx] == 0) {
			bfs(nx, ny);
		}
	}
	return;
}
int main() {
	cin >> m >> n >> k;
	for(int i = 0; i < k; i++){
		int x1, x2, y1, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		for(int j = y1; j < y2; j++){
			for(int k = x1; k < x2; k++) {
				a[j][k] = 1;
			}
		}
	}
	
	for(int i = 0; i < m; i++) {
		for(int j = 0; j < n; j++){
			if(a[i][j] == 0 && visited[i][j] == 0) {
				bfs(j, i);
				v.push_back(tmp);
			}
			tmp = 0;
		}
	}
	sort(v.begin(), v.end());
	cout << v.size() << "\n";
	for(int x : v) cout << x << " ";
	
	return 0;
}