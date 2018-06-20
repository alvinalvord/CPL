import java.util.*;

public class Main {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		
		while (sc.hasNextLine ()) {
			int[] capscount = new int[26];
			int[] lowcount = new int[26];
			
			String str = sc.nextLine ();
			
			for (int i = 0; i < str.length (); i++) {
				if (str.charAt (i) >= 'A' && str.charAt (i) <= 'Z')
					capscount[str.charAt (i) - 'A']++;
				else if (str.charAt (i) >= 'a' && str.charAt (i) <= 'z')
					lowcount[str.charAt (i) - 'a']++;
			}
			
			int max = 0;
			for (int i = 0; i < 26; i++) {
				if (capscount[i] > max)
					max = capscount[i];
				if (lowcount[i] > max)
					max = lowcount[i];
			}
			
			String out = "";
			for (int i = 0; i < 26; i++) {
				if (capscount[i] == max)
					out += (char) (i + 'A');
			}
			
			for (int i = 0; i < 26; i++) {
				if (lowcount[i] == max)
					out += (char) (i + 'a');
			}
			
			System.out.println (out + " " + max);
		}
		
	}
	
}