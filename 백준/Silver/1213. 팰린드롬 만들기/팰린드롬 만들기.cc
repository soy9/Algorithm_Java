#include <bits/stdc++.h>
using namespace std;
string name;
char pal[50];
int arr[26], odd;

void makePal(){
	int tmp = 0;
	
	for(int i = 0; i < 26; i++){
		if(arr[i] > 0){
			if(arr[i] % 2 == 1){
				pal[name.size()/2] = (char)('A'+i);
			}
			if(arr[i] > 1){	
				for(int j = 0; j < arr[i]/2; j++){
					pal[tmp] = (char)(i+'A');
					pal[name.size() - 1 - tmp] = (char)(i+'A');
					tmp++;
				}
			}
		}
	}
	cout << pal << "\n"; 
	return;	
}

int main() {
	cin >> name;
	
	for(int i = 0; i < name.size(); i++){
		arr[name[i]-'A']++;
		if(arr[name[i]-'A'] % 2 == 1) {
			odd++;
		} else{
			odd--;
		}
	}
	if(name.size() % 2 == 1){
		if(odd == 1){
			makePal();
		} else if(odd > 1){
			cout << "I'm Sorry Hansoo\n";
			return 0;
		} else {
			makePal();
		}
	} else{
		if(odd == 0){
			makePal();
		} else{
			cout << "I'm Sorry Hansoo\n";
			return 0;
		}
	}
	
	return 0;
}