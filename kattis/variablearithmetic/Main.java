import java.util.*;
import java.io.*;

public class Main {
	
	static boolean isInt (String s) {
		try {
			Integer.parseInt (s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		HashMap<String, Integer> map = new HashMap <> ();
		
		while (true) {
			String in = br.readLine ();
			if (in.equals ("0")) break;
			if (in.length () == 0) continue;
			
			if (in.contains ("=")) {
				String[] temp = in.split ("\\s+=\\s+");
				map.put (temp[0], Integer.parseInt (temp[1]));
			} else {
				String[] temp = in.split ("\\s+\\+\\s+");
				List<String> list = new ArrayList <> ();
				int value = 0;
				for (int i = 0; i < temp.length; i++) {
					if (isInt(temp[i])) value += Integer.parseInt (temp[i]);
					else if (!map.containsKey (temp[i])) {
						map.put (temp[i], -1);
						list.add (temp[i]);
					} else {
						if (map.get (temp[i]) < 0) list.add (temp[i]);
						else value += map.get (temp[i]);
					}
				}
				
				StringBuilder sb = new StringBuilder ();
				if (value > 0) sb.append (value);
				
				for (int i = 0; i < list.size (); i++) {
					if (sb.length () > 0)
						sb.append (" + ").append (list.get (i));
					else
						sb.append (list.get (i));
				}
				System.out.println (sb.toString ());
			}
		}
		
	}
	
}