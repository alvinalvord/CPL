import java.util.*;

public class Main {
	
	static class P {
		int s, e;
		P (int s, int e) {this.s = s; this.e = e;}
	}
	
	public static int func (int[] arr, int s, int e) {
		int colCtr = e - s;
		if (colCtr == 0) return 0;
		if (colCtr == 1) return 1;
		
		int min = Integer.MAX_VALUE;
		for (int i = s; i < e; i++)
			if (arr[i] < min)
				min = arr[i];
		
		for (int i = s; i < e; i++)
			arr[i] -= min;
		
		ArrayList <P> pairs = new ArrayList<> ();
		
		int i = s, j;
		while (i < e) {
			while (i < e && arr[i] == 0) i++;
			j = i;
			while (i < e && arr[i] != 0) i++;	
			pairs.add (new P (j, i));
		}
		
		int val = min;
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
