import java.util.*;

public class A {
	
	static List<String> list = new ArrayList <> ();
	static List<P> morse = new ArrayList<>();

	static class P {
		String code, ch;
		public P (String ch, String code) {
			this.ch = ch;
			this.code = code; 
		}
	}
	
	public static void init () {
		morse.add (new P ("A", "-"));
		morse.add (new P ("B", "--."));
		morse.add (new P ("C", ".--"));
		morse.add (new P ("D", "-.-"));
		morse.add (new P ("E", "."));
		morse.add (new P ("F", "..-"));
		morse.add (new P ("G", "---."));
		morse.add (new P ("H", "..--"));
		morse.add (new P ("I", "-."));
		morse.add (new P ("J", "---"));
		morse.add (new P ("K", "..."));
		morse.add (new P ("L", ".-."));
		morse.add (new P ("M", ".-.-"));
		morse.add (new P ("N", ".-.."));
		morse.add (new P ("O", ".."));
		morse.add (new P ("P", ".--."));
		morse.add (new P ("Q", "--.."));
		morse.add (new P ("R", ".-..-"));
		morse.add (new P ("S", "....-"));
		morse.add (new P ("T", "-..--"));
		morse.add (new P ("U", "--"));
		morse.add (new P ("V", "-.-.."));
		morse.add (new P ("W", "--..-"));
		morse.add (new P ("X", ".-.-."));
		morse.add (new P ("Y", "....."));
		morse.add (new P ("Z", "-----"));
	}
	
	public static void genAll (StringBuilder code, StringBuilder text, String codein, String textin, String input) {
		code.append (codein);
		text.append (textin);
		
		if (code.length () > input.length ())
			return;
		
		if (code.length () == input.length ()) {
			if (input.equals (code.toString ()))
				list.add (text.toString ());
			return;
		}
		
		for (int i = 0; i < code.length () && i < input.length (); i++) {
			if (input.charAt (i) != code.charAt (i))
				return;
		}
		
		for (int i = 0; i < morse.size (); i++) {
			if (code.length () + morse.get(i).code.length () <= input.length ())
				genAll (new StringBuilder (code), new StringBuilder (text), morse.get(i).code, morse.get (i).ch, input);
		}
	}
	
	public static void main (String[] args) {
		init ();
		Scanner sc = new Scanner (System.in);
		String in = sc.nextLine ();
		
		genAll (new StringBuilder (), new StringBuilder (), "", "", in);
		
		for (String str: list)
			System.out.println (str);
	}
	
}