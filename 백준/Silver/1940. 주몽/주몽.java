import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in); 
		
		int N = sc.nextInt(); 
		int M = sc.nextInt(); 
		
		int [] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr); 
		
		int i = 0, count = 0, j = N - 1;
		
		while(i < j) {
			if(arr[i] + arr[j] > M) j--;
			else if(arr[i] + arr[j] < M) i++;
			else {count++; i++; j--;}
		}
		
		System.out.println(count);
    }
}