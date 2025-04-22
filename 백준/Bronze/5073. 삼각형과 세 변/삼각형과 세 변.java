import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String[] line = br.readLine().split(" ");
			ArrayList<Integer> nums = new ArrayList<>();
			for (String s : line) {
				nums.add(Integer.parseInt(s));
			}
			
			if (nums.get(0).equals(0) && nums.get(1).equals(0) && nums.get(2).equals(0)) {
				break;
			}
			
			nums.sort(Comparator.naturalOrder());
			
			if (nums.get(2) >= nums.get(0) + nums.get(1)) {
				bw.append("Invalid").append("\n");
				continue;
			}
			
			
			if (nums.get(0).equals(nums.get(1)) && nums.get(1).equals(nums.get(2))) {
				bw.append("Equilateral").append("\n");
				continue;
			}
			
			if (nums.get(0).equals(nums.get(1)) 
					|| nums.get(1).equals(nums.get(2))
					|| nums.get(0).equals(nums.get(2))) {
				bw.append("Isosceles").append("\n");
				continue;
			}
			
			if (!nums.get(0).equals(nums.get(1))
					&& !nums.get(1).equals(nums.get(2))
					&& !nums.get(0).equals(nums.get(2))) {
				bw.append("Scalene").append("\n");
				continue;
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
