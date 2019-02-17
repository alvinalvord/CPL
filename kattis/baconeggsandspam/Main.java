import java.util.*;

public class Main {
	
	static class N {
		String item;
		List<String> names;
		
		N (String item) {
			this.item = item;
			names = new ArrayList<> ();
		}
		
		void add (String name) {
			names.add (name);
		}
		
		public String toString () {
			names.sort ((a, b) -> {return a.compareTo (b); });
			StringBuilder sb = new StringBuilder ();
			sb.append (item);
			
			for (String name: names) {
				sb.append (' ').append (name);
			}
			return sb.toString ();
		}
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		while (true) {
			int n = Integer.parseInt (sc.nextLine ());
			if (n == 0) break;
			List<N> nodes = new ArrayList <> ();
			HashMap<String, N> map = new HashMap<> ();
			
			for (int i = 0; i < n; i++) {
				String[] arr = sc.nextLine ().split (" ");
				
				for (int j = 1; j < arr.length; j++) {
					if (map.get (arr[j]) == null) {
						N node = new N (arr[j]);
						nodes.add (node);
						map.put (arr[j], node);
					}
					
					map.get (arr[j]).add (arr[0]);
				}
				
			}
			
			nodes.sort ((a, b) -> {return a.item.compareTo(b.item);});
			
			for (N node: nodes) {
				System.out.println (node);
			}
			System.out.println ();
		}
		
		
		
	}
	
}