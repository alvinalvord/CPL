import java.util.*;

public class Main {
	
	static char[] arr;
	static char[] in;
	static List<List<String>> list;
	
	public static void genAll (int dex, int next) {
		if (dex < 0) {
			for (int i = 0; i < in.length; i++) {
				genAll (dex + 1, i);
			}
		} else {
			arr[dex] = in[next];
			if (dex == 2) {
				String temp = new String (arr);
				int pos = arr[0] - 'A';
				if (!list.get (pos).contains(temp))
					list.get (pos).add (temp);
				return;
			}
			
			for (int i = next + 1; i < in.length; i++) {
				genAll (dex + 1, i);
			}
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt (); sc.nextLine ();
		arr = new char[3];
		list = new ArrayList<> (26);
		for (int i = 0; i < 26; i++)
			list.add (new ArrayList<> ());
		
		while (n-->0) {
			in = sc.nextLine ().toCharArray ();
			genAll (-1, 0);
			int sum = 0;
			for (int i = 0; i < 26; i++)
				sum += list.get (i).size ();
			System.out.println (sum);
			for (int i = 0; i < 26; i++)
				list.get(i).clear ();
		}
	}
	
}