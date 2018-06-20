import java.util.*;

public class Main {
	
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList<String> list = new ArrayList<String> ();
		ArrayList<StringBuilder> sblist = new ArrayList <> ();
		
		int max = 0;
		while (sc.hasNextLine ()) {
			String temp = sc.nextLine ();
			if (temp.length () > max)
				max = temp.length ();
			list.add (temp);
		}
		
		for (int i = 0; i < max; i++) {
			sblist.add (new StringBuilder ());
		}
		
		for (int i = 0; i < max; i++) {
			for (int j = list.size () - 1; j >= 0; j--) {
				if (i < list.get (j).length ())
					sblist.get (i).append (list.get (j).charAt (i));
				else sblist.get (i).append (" ");
			}
		}
		
		for (StringBuilder ss: sblist)
			System.out.println (ss.toString ());
	}
	
}