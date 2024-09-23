import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CharacterCodingException;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            String input = br.readLine().trim();
            Stack<Character> stack = new Stack<>();
            
            for (int j = 0; j < input.length(); j++) {
                if (!stack.isEmpty() && input.charAt(j) == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(input.charAt(j));
                }
            }
            if (stack.isEmpty()) { 
                result++;
            }
        }
        
        System.out.println(result);
    }
}
