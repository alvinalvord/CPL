public class CF251A {
	
	public static void main (String[] args) {
		java.util.Scanner sc = new java.util.Scanner (System.in);
		int n = sc.nextInt ();
		long d = sc.nextLong ();
		
		long[] in = new long[n];
		
		for (int i = 0; i < n; i++)
			in[i] = sc.nextLong ();
		
		int ctr = 0;
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 2; j < n; j++) {
				if (in[j] - in[i] <= d) {
					ctr += (j - i - 1);
				}
				else break;
			}
		}
		
		System.out.println (ctr);
	}
	
}