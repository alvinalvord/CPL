import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int[] arr = new int[n];
		HashMap <Integer, Integer> map = new HashMap <> ();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
			if (map.get (arr[i]) != null)
				map.put (arr[i], map.get (arr[i]) + 1);
			else
				map.put (arr[i], 1);
		}
		
		int[] pow2 = new int[31];
		
		pow2[0] = 1;
		for (int i = 1; i < 31; i++) {
			pow2[i] = pow2[i-1] << 1;
		}
		
		boolean flag;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			flag = false;
			for (int j = 0; j < 31; j++) {
				int temp = pow2[j] - arr[i];
				if (temp <= 0) continue;
				if (map.get(temp) == null) continue;
				if (arr[i] == temp && map.get (temp) > 1) {
					flag = true;
					break;
				}
				else if (map.get (temp) != null && temp != arr[i]) {
					flag = true;
					break;
				}
			}
			if (!flag) count++;
		}
		
		System.out.println (count);
	}
	
}