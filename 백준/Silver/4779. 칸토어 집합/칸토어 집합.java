import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            int num = (int) Math.pow(3, Integer.parseInt(input));
            
            String s = "-".repeat(num);
            if(num > 1) {
                s = cantor(s, num);
            }
               
            sb.append(s).append("\n");
        }
        
        System.out.print(sb);
		
	}
    
    static String cantor(String str, int len) {
        if(len == 1) {
            return "-";
        }
        int nextLen = len / 3;

        String sideStr = cantor(str.substring(0, nextLen - 1), nextLen);
        String midStr = " ".repeat(nextLen);
        
        return sideStr + midStr + sideStr;
    }

}