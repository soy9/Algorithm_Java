import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] numToString = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            numToString[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(numToString, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return ((o2 + o1).compareTo(o1 + o2));
			}
		});

        if(numToString[0].equals("0")){
            return "0";
        }
               
        String answer = "";
        for(String num : numToString){
            answer += num;
        }
        return answer;
    }
}