import java.util.*;

public class Main {
	
	public static int max (int a, int b, int c) {
		int m = a;
		if (b > m) b = m;
		return (c > m ? c : m);
	}
	
	public static int LCS (String a, String b) {
		int n = a.length () + 1;
		int m = b.length () + 1;
		int[][] arr = new int[n][m];
		
		for (int i = 0; i < n; i++) arr[i][0] = 0;
		for (int i = 0; i < m; i++) arr[0][i] = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[i][j] = max (arr[i][j-1], arr[i-1][j], arr[i-1][j-1] + 
					(a.charAt (i-1) == b.charAt (j-1) ? 1 : 0));
			}
		}
		return arr[n-1][m-1];
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (true) {
			if (!sc.hasNextLine ()) break;
			StringBuilder a = new StringBuilder (), b = new StringBuilder ();
			boolean flag = false;
			ArrayList <String> s1 = new ArrayList<> (), 
				s2 = new ArrayList<> (), out = new ArrayList <> (), 
				tempa = new ArrayList <> ();
			while (sc.hasNextLine ()) {
				String in = sc.nextLine ();
				if (in.equals ("#")) {
					if (flag == false) flag = true;
					else break;
					continue;
				}
				
				String[] temp = in.split ("\\s{1,}");
				for (String s : temp) {
					if (!flag) {
						s1.add (s);
					} else s2.add (s);
				}
			}
			HashMap <String, Integer> map = new HashMap <> ();
			for (int i = 0; i < s1.size (); i++) {
				map = new HashMap <> ();
				tempa = new ArrayList <> ();
				int minj = 0;
				for (int k = i; k < s1.size (); k++) {
					String x = s1.get (k);
					if (map.get (x) == null) {
						for (int j = minj; j < s2.size (); j++) {
							String y = s2.get (j);
							if (x.length () == y.length ()) {
								int lcs = LCS (x, y);
								if (lcs == x.length ()) {
									map.put (x, 0);
									tempa.add (x);
									minj = j + 1;
									break;
								}
							}
						}
					}
				}
				if (tempa.size () > out.size ())
					out = tempa;
			}
			
			StringBuilder sb = new StringBuilder ();
			sb.append (out.get (0));
			
			for (int i = 1; i < out.size (); i++)
				sb.append (" ").append (out.get (i));
			
			System.out.println (sb.toString ());
		}
		
		
	}
	
}