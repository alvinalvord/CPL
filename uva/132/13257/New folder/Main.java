import java.util.*;

public class Main {
	
	Scanner sc;
	
	public void func () {
		char[] arr = sc.nextLine ().toCharArray ();
		BitSet bs = new BitSet (26 * 26 * 26);
		short[] count = new short[26 * 26]; 
		int i, j, k, index, countIndex, ctr = 0;
		
		for (i = 0; i < arr.length - 2; i++) {
			for (j = i + 1; j < arr.length - 1; j++) {
				countIndex = (arr[i] - 'A') * 26 + (arr[j] - 'A');
				if (count[countIndex] >= 26) continue;
				
				for (k = j + 1; k < arr.length; k++) {
					index = (arr[i] - 'A') * 26 * 26 + (arr[j] - 'A') * 26 + (arr[k] - 'A');
					if (!bs.get (index)) {
						bs.set (index);
						ctr ++;
						
						count[countIndex] ++;
						if (count[countIndex] >= 26) break;
					}
				}
			}
		}
		
		System.out.println (ctr);
	}
	
	public void run () {
		sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		sc.nextLine ();
		
		while (n-->0) {
			func ();
		}
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}