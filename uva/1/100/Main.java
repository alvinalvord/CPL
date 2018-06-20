import java.util.*;

public class Main {
	
	static HashMap <Long, Long> map = new HashMap <> ();
	static long lim = 1000000;
	
	static long func (long n) {
		if (map.get (n) == null) {
			if (n % 2 == 0)
				return func (n / 2) + 1;
			else
				return func (3 * n + 1) + 1;
		} else {
			return map.get (n);
		}
	}
	
	static void init () {
		map.put (1L, 1L);
		for (long i = 2; i <= lim; i++) {
			map.put (i, func (i));
		}
	}
	
	public static void main (String[] args) {
		init ();
		
		for (long i = 1; i <= lim; i++)
			System.out.println (i + " "+ map.get (i));
	}
	
}