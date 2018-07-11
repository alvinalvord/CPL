import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		String s = sc.nextLine ();
		
		int[] arr = new int[s.length ()];
		for (int i = 0; i < s.length (); i++) {
			arr[i] = s.charAt (i) - '0';
		}
		
		int cur = 0;
		int ctr = 0;
		int i = 0, j;
		boolean flag;
		while (i < arr.length) {
			j = i;
			cur = arr[i];
			flag = false;
			do {
				if (cur % 3 == 0) {
					i = j + 1;
					ctr ++;
					flag = true;
					break;
				} else if (j + 1 < arr.length) {
					j++;
					cur += arr[j];
				} else break;
			} while (cur <= 24);
			if (!flag)
				i++;
		}
		
		System.out.println (ctr);
	}
	
}