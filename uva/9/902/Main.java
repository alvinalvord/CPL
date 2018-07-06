import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (true) {
			if (!sc.hasNextLine ()) break;
			
			String[] temp = sc.nextLine ().split ("\\s{1,}");
			if (temp.length != 2) {
				String[] fuckingInput = new String[2];
				fuckingInput[0] = temp[0];
				fuckingInput[1] = sc.nextLine ();
				temp = fuckingInput;
			}
			
			int n = Integer.parseInt (temp[0]);
			String in = temp[1];
			HashMap <String, Integer> map = new HashMap <> ();
			
			for (int i = 0; i < in.length () - n + 1; i++) {
				String t = in.substring (i, i + n);
				
				if (map.get(t) == null) {
					map.put (t, 1);
				} else map.put (t, map.get(t) + 1);
			}
			
			int max = 0;
			String mkey = "";
			Iterator<Map.Entry<String, Integer>> iter = map.entrySet ().iterator ();
			while (iter.hasNext ()) {
				Map.Entry <String, Integer> p = iter.next ();
				String key = p.getKey ();
				int val = p.getValue ();
				if (val > max) {
					mkey = key;
					max = val;
				}
			}
			
			System.out.println (mkey);
		}
	}
	
}