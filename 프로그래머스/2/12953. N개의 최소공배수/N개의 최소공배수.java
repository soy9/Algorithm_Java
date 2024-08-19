import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        Arrays.sort(arr);
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 1) {
                answer = arr[i];
                break;
            }
        }
             
        for(int i = 1; i < arr.length; i++) {
            if(answer == arr[i]){
                continue;
            }
            answer = findLCM(Math.min(answer, arr[i]), Math.max(answer, arr[i]));
        }
        
        return answer;
    }
    
    int findLCM(int a, int b) {
        int minVal = a;
        int res = 1;
        int n = 2;
        while(n <= minVal) {
            if(a % n == 0 && b % n == 0) {
                res *= n;
                a /= n;
                b /= n;
            }
            
            if(a == 1 || b == 1) {
                break;
            } else if(a % n != 0 || b % n != 0) {
                n++;
            } 
        }
        
        return res * a * b;
    }
}