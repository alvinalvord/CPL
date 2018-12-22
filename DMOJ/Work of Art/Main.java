import java.util.*;

public class Main {
	
	static class P {
		int s, e;
		P (int s, int e) {this.s = s; this.e = e;}
	}
	
	public static int func (int[] arr, int s, int e) {
		int colCtr = e - s;
		if (colCtr == 0) return 0;
		
		for (int i = s; i < e; i++)
			arr[i]--;
		
		ArrayList <P> pairs = new ArrayList<> ();
		
		int i = s, j;
		while (i < e) {
			while (i < e && arr[i] == 0) i++;
			j = i;
			while (i < e && arr[i] != 0) i++;	
			pairs.add (new P (j, i));
		}
		
		int val = 1;
		for (int x = 0; x < pairs.size (); x ++) {
			val += func (arr, pairs.get (x).s, pairs.get (x).e);
		}
		
		return Math.min (colCtr, val);
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt ();
		
		System.out.println (func (arr, 0, n));
		
	}
	
	
}
