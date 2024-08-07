// class Solution {
//     public long solution(long n) {
//         long answer = -1;
        
//         for(long i = 2; (i * i) <= n; i++){
//             if((i * i) == n) {
//                 answer = (i + 1)*(i + 1);
//                 break;
//             }
//         }
      
//         return answer;
//     }
// }

class Solution {
    public long solution(long n) {
		long answer = 0;

		while(answer * answer < n){
			answer++;
		}

		if(answer * answer == n){
			answer++;
			answer*=answer;
		}else{
			answer = -1;
		}
		return answer;
    }
}