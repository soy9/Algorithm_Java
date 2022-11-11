#include<iostream>
#include<string.h>
#include<vector>
using namespace std;
string num;
vector<int> ret;

bool numCheck(string s){
	return {s == "0001101" || s == "0011001" || s == "0010011" || s == "0111101" || s == "0100011" || 
		s == "0110001" || s == "0111011" || s == "0111011" || s == "0110111" || s == "0001011"};
}
void aa(int x){
	int a[8], pos = 0, oddN, evenN, n;
	
	pos = num.rfind("1");
	pos = pos - 55;
	for(int j = 0; j < 8; j++){
		string tmp = num.substr(pos, 7);
		if(tmp == "0001101"){
			a[j] = 0;
		} else if(tmp == "0011001"){
			a[j] = 1;
		} else if(tmp == "0010011"){
			a[j] = 2;
		} else if(tmp == "0111101"){
			a[j] = 3;
		} else if(tmp == "0100011"){
			a[j] = 4;
		} else if(tmp == "0110001"){
			a[j] = 5;
		} else if(tmp == "0101111"){
			a[j] = 6;
		} else if(tmp == "0111011"){
			a[j] = 7;
		} else if(tmp == "0110111"){
			a[j] = 8;
		} else if(tmp == "0001011"){
			a[j] = 9;
		}
		pos = pos + 7;
	}
	oddN = a[0] + a[2] + a[4] + a[6];
	evenN = a[1] + a[3] + a[5] + a[7];
	n = (oddN * 3) + evenN;
	
	if(n > 0 && n % 10 == 0) {
		ret.push_back(oddN + evenN);
	} else{
		ret.push_back(0);
	}
	return;
}

int main(){
	int test_case, T;
	int y, x;
	bool flag;
	
	cin >> T;
	for(test_case = 1; test_case <= T; ++test_case){
		cin >> y >> x;
		flag = 0;
		for(int i = 0; i < y; i++){
			cin >> num;
			
			if(!flag && num.find("1") != string::npos){
				aa(x);
				flag = 1;
			} 
		}
	}
	
	for(test_case = 1; test_case <= T; ++test_case){
		cout << "\n#" << test_case << " " << ret[test_case - 1];
	}
	
	return 0;
}