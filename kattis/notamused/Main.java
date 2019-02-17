import java.util.*;

public class Main {
	
	static class Person {
		String name;
		int total;
		int lastEnter;
		
		Person (String name) {
			this.name = name;
			total = 0;
			lastEnter = 0;
		}
		
		void enter (int n) {
			lastEnter = n;
		}
		
		void exit (int n) {
			total += n - lastEnter;
		}
		
		public String toString () {
			return String.format ("%s $%.2f", name, total * 0.1);
		}
		
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int day = 1;
		while (sc.hasNext ()) {
			if (day > 1) System.out.println ();
			String in = sc.nextLine ();
			List<Person> people = new ArrayList<> ();
			HashMap<String, Person> map = new HashMap <> ();
			
			while (true) {
				in = sc.nextLine ();
				if (in.charAt (0) == 'C') break;
	
				String[] temp = in.split (" ");
				if (in.charAt (1) == 'N') {
					if (map.get (temp[1]) == null) {
						Person p = new Person (temp[1]);
						people.add (p);
						map.put (temp[1], p);
					}
					
					map.get (temp[1]).enter (Integer.parseInt (temp[2]));
				} else {
					map.get (temp[1]).exit (Integer.parseInt (temp[2]));
				}
				
			}
			
			people.sort ((a,b)->{return a.name.compareTo (b.name);});
			System.out.println ("Day " + day);
			for (Person p: people) 
				System.out.println (p);
			day ++;
		}
		
	}
	
}