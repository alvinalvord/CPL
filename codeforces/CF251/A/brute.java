public class brute {
	
	public static void main (String[] args) {
		java.util.Scanner sc = new java.util.Scanner (System.in);
		int n = sc.nextInt ();
		long d = sc.nextLong ();
		
		long[] in = new long[n];
		
		for (int i = 0; i < n; i++)
			in[i] = sc.nextLong ();
		
		int ctr = 0;
		
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					if (in[k] - in[i] <= d) {
						ctr++;
					}
				}
			}
		}
		
		System.out.println (ctr);
	}
	
}