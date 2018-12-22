import java.util.*;

public class Main {
	
	static class P {
		int a, index;
		P (int a, int index) {this.a = a; this.index = index;}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt ();
		int k = sc.nextInt ();
		int[] arr = new int[n];
		P[] sorted = new P[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt ();
			sorted[i] = new P (arr[i], i);
		}
		
		Arrays.sort (sorted, ( (a, b) -> Integer.compare (a.a, b.a) ));
		P[] max = new P[k];
		int ctr = 0;
		int dex = n - 1;
		while (ctr < k) {
			max[ctr] = sorted[dex];
			ctr++; dex--;
		}
		
		Arrays.sort (max, ((a, b) -> Integer.compare (a.index, b.index)));
		int sum = 0;
		
		for (int i = 0; i < k; i++)
			sum += max[i].a;
		
		int[] out = new int[k];
		for (int i = 0; i < k ; i++) {
			if (i > 0) {
				out[i] = max[i].index - max[i-1].index;
			} else {
				out[i] = max[i].index + 1;
			}
		}
		
		out[k-1] += n - max[k-1].index - 1;
		
		System.out.println (sum);
		for (int i = 0; i < k; i++) {
			System.out.print (out[i] + " ");
		}
		
	}
	
}
