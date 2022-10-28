#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, nx, ny;
int a[104][104];
int visited[104][104];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};

int main() {
	cin >> m >> n;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			scanf("%1d", &a[i][j]);
		}
	}
	
	queue<pair<int, int>> q;
	q.push({0, 0});
	visited[0][0] = 1;
	
	while(q.size()) {
		tie(y, x) = q.front();
		q.pop();
		
		for(int i = 0; i < 4; i++){
			nx = x + dx[i];
			ny = y + dy[i];
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || a[ny][nx] == 0){
				continue;
			}
			if(visited[ny][nx] == 0) {
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ny, nx});
			}
		}                             
	}
	
	if(visited[m-1][n-1]) {
		cout << visited[m-1][n-1];
	}
	
	return 0;
}