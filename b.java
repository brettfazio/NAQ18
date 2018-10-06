import java.util.Scanner;
import java.util.TreeSet;

public class b {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int p = sc.nextInt();
		int q = sc.nextInt();
		
		int s = sc.nextInt();
		
		TreeSet<Integer> set = new TreeSet<>();
		
		int pp = p;
		int times = 1;
		while (pp <= s) {
			set.add(pp);
			pp += p;
		}
		
		int qq = q;
		while (qq <= s) {
			if (set.contains(qq)) {
				System.out.println("yes");
				return;
			}
			qq += q;
		}
		
		System.out.println("no");
		
	}

}
