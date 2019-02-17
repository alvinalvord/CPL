import java.util.*;
import java.io.*;

public class Main {
	
	public static int p (String s) {
		return Integer.parseInt (s);
	}
	
	public static int lsb (int i) {
		return i & -i;
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		String[] temp = br.readLine ().split ("\\s+");
		int n = p(temp[0]) + 5;
		int q = p(temp[1]);
		int[] arr = new int[n];
		
		for (int i = 0; i < q; i++) {
			temp = br.readLine ().split ("\\s+");
			if (temp[0].charAt (0) == '+') {
				int j = p(temp[1]) + 1;
				int k = p(temp[2]);
				
				while (j < n) {
					arr[j] += k;
					j += lsb (j);
				}					
			
			} else {
				int j = p(temp[1]);
				if (j == 0) System.out.println (0);
				else {
					j += 1;
					int sum = 0;
					while (j > 0) {
						sum += arr[j];
						j -= lsb (j);
					}
					System.out.println (sum);
				}
			}
		}
		
	}
	
}