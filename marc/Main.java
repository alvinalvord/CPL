import java.util.*;

public class Main {
	
	static List<Main> states;
	static HashMap<Integer, Integer> visited;
	static int M;
	static int T;
	static int[] nums;
	static boolean add;
	static boolean sub;
	static boolean mult;
	static boolean div;
	int cur;
	int depth;
	boolean opd;
	
	Main () {
		add = sub = mult = div = false;
		states = new ArrayList <> (1000);
		visited = new HashMap <> ();
		depth = 0;
		opd = false;
	}
	
	Main (int cur, int depth, boolean opd) {
		this.cur = cur;
		this.depth = depth;
		this.opd = opd;
	}
	
	public List<Main> next () {
		List<Main> list = new ArrayList <> ();
		int temp;
		
		if (depth + 3 <= M) {
			if (add) {
				for (int i = 0; i < nums.length; i++) {
					temp = cur + nums[i];
					if (visited.get (temp) == null) {
						list.add (new Main (temp, depth + 2, true));
						visited.put (temp, 1);
					}
				}
			}
			if (sub) {
				for (int i = 0; i < nums.length; i++) {
					temp = cur - nums[i];
					if (visited.get (temp) == null) {
						list.add (new Main (temp, depth + 2, true));
						visited.put (temp, 1);
					}
				}
			}
			if (mult) {
				for (int i = 0; i < nums.length; i++) {
					temp = cur * nums[i];
					if (visited.get (temp) == null) {
						list.add (new Main (temp, depth + 2, true));
						visited.put (temp, 1);
					}
				}
			}
			if (div) {
				for (int i = 0; i < nums.length; i++) {
					if (nums[i] == 0)
						continue;
					temp = cur / nums[i];
					if (visited.get (temp) == null) {
						list.add (new Main (temp, depth + 2, true));
						visited.put (temp, 1);
					}
				}
			}
		}
		
		if (depth + 1 + (opd ? 1: 0) <= M) {
			for (int i = 0; i < nums.length; i++) {
				temp = cur * 10 + nums[i];
				if (visited.get (temp) == null) {
					list.add (new Main (temp, depth + 1, opd));
					visited.put (temp, 1);
				}
			}
		}
		
		return list;
	}
	
	public void solve () {
		for (int i = 0; i < nums.length; i++) {
			states.add (new Main (nums[i], 1, false));
			visited.put (nums[i], 1);
		}
		
		while (!states.isEmpty ()) {
			Main cs = states.remove (0);
			
			if (cs.cur == T) {
				System.out.println (cs.depth + (cs.opd ? 1: 0));
				return;
			} else {
				states.addAll (cs.next ());
			}
		}
		
		System.out.println ("-1");
	}
	
	public void run () {
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt ();
		int O = sc.nextInt ();
		     M = sc.nextInt ();
		
		nums = new int[N];
		for (int i = 0; i < N; i++)
			nums[i] = sc.nextInt ();
		
		for (int i = 0; i < O && i < 4; i++) {
			int temp = sc.nextInt ();
			switch (temp) {
				case 1: add = true; break;
				case 2: sub = true; break;
				case 3: mult = true; break;
				case 4: div = true; break;
			}
		}
		
		T = sc.nextInt ();
		
		if (!sub && T < 0) {
			System.out.println ("-1");
		}
		else if (!sub && !div && T == 0) {
			boolean flag = false;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == 0) {
					System.out.println ("1");
					flag = true;
					break;
				}
			}
			if (!flag) System.out.println ("-1");
		} else {
			solve ();
		}
	}
	
	public static void main (String[] args) {
		new Main ().run ();
	}
	
}