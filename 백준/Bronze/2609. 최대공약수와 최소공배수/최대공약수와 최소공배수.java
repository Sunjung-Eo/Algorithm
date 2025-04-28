import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] line = br.readLine().split(" ");
    	int n = Integer.parseInt(line[0]);
    	int m = Integer.parseInt(line[1]);
        int gcd = n;
    	
    	if (n >= m) {
    		gcd = gcd(n, m);
    	} else {
    		gcd = gcd(m, n);
    	}
    	
    	int lcm = (n * m)/gcd;
    	
        System.out.println(gcd);
        System.out.println(lcm);
        br.close();
    }

	private static int gcd(int n, int m) {
		if (m==0) {
			return n;
		} 
		
		return gcd(m, n%m);
	}

}
