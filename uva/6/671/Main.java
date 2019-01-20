import java.util.*;

public class Main {
	
	Scanner sc;
	ArrayList<String> dict;
	
	public Main () {
		sc = new Scanner (System.in);
	}
	
	public int min (int a, int b, int c) {
		int m = a;
		if (b < m)
			m = b;
		return c < m ? c : m;
	} 
	
	public int abs (int x) {
		return x > 0 ? x: -x;
	}
	
	public int edit (String a, String b) {
		if (abs (a.length () - b.length ()) > 1) return 2;
		
		int i = 0, j = 0, err = 0;
		
		while (i < a.length () && j < b.length ()) {
			if (a.charAt (i) == b.charAt (j)) {
				i++;
				j++;
			} else {
				if (err == 1) return 2;
				if (a.length () > b.length ()) i++;
				else if (a.length () < b.length ()) j++;
				else {
					i++; j++;
				}
				err ++;
			}
		}
		
		if (i < a.length () || j < b.length ()) err++;
		
		return err;
		/* int[][] arr = new int[a.length () + 1][b.length () + 1];
		
		for (int i = 0; i <= a.length (); i++) {
			arr[i][0] = i;
		}
		for (int i = 0; i <= b.length (); i++) {
			arr[0][i] = i;
		}
		
		for (int i = 1; i <= a.length (); i++) {
			for (int j = 1; j <= b.length (); j++) {
				if (a.charAt(i-1) == b.charAt (j-1)) {
					arr[i][j] = arr[i-1][j-1];
				} else {
					arr[i][j] = min (
						arr[i-1][j-1] + 1,
						arr[i-1][j] + 1,
						arr[i][j-1] + 1
					);
				}
			}
		}
		
		return arr[a.length ()][b.length ()]; */
	}
	
	public void f () {
		dict = new ArrayList<> ();
		
		while (true) {
			String temp = sc.nextLine ();
			if (temp.length () > 0 && temp.charAt (0) == '#') break;
			dict.add (temp);
		}
		
		List<Integer> list = new ArrayList<> ();
		while (true) {
			String temp = sc.nextLine ();
			if (temp.length () > 0 && temp.charAt (0) == '#') break;
			
			boolean flag = false;
			list.clear ();
			StringBuilder sb = new StringBuilder ();
			sb.append (temp);
			
			for (int i = 0; i < dict.size (); i++) {
				int distance = edit (dict.get (i), temp);
				if (distance == 0) {
					flag = true;
					list.clear ();
					break;
				}
				else if (distance == 1) {
					list.add (i);
				}
			}
			
			if (flag) {
				sb.append (" is correct");
				System.out.println (sb.toString ());
			} else {
				sb.append (':');
				for (int x: list) {
					sb.append (' ').append (dict.get (x));
				}
				System.out.println (sb.toString ());
			}
		}
	}
	
	public void run () {
		int n = Integer.parseInt (sc.nextLine ());
		
		for (int i = 0; i < n; i++) {
			sc.nextLine ();
			f ();
			if (i < n - 1) System.out.println ();
		}
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}