import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String expr = br.readLine(); 

        List<Double> numberList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            Double num = Double.parseDouble(br.readLine());
            numberList.add(num);
        }

        Stack<Double> numberStack = new Stack<>(); 

        for (int i = 0; i < expr.length(); i++) {
            char ch = expr.charAt(i);

            if (ch >= 'A' && ch <= 'Z') { 
                numberStack.push(numberList.get(ch - 'A'));
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                double num1 = numberStack.pop();
                double num2 = numberStack.pop();

                switch (ch) {
                    case '+':
                        numberStack.add(num2 + num1);
                        break;
                    case '-':
                        numberStack.add(num2 - num1);
                        break;
                    case '*':
                        numberStack.add(num2 * num1);
                        break;
                    case '/':
                        numberStack.add(num2 / num1);
                        break;
                }
            }
        }
        System.out.printf("%.2f", numberStack.pop());
    }
}