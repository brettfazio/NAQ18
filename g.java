import java.util.ArrayList;
import java.util.Scanner;

public class g {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		char[] s = sc.next().toCharArray();
		
		ArrayList<Integer> order = new ArrayList<>();
		boolean[] closed = new boolean[n+1];
		int start = 1;
		int idx = 0;
		for (idx = 0; idx < s.length && s[idx] == 'L'; idx++) {
			start++;
		}
		int cur = start;
		int next = start;
		idx = 0;
		for (idx = 0; idx < s.length; idx++) {
			closed[cur] = true;
			order.add(cur);
			if (s[idx] == 'R' && idx+1 < s.length && s[idx+1] == 'R') {
				if (cur != next) cur =next;
				cur++;
				next++;
			}else if (s[idx] == 'R' && idx+1 < s.length && s[idx+1] == 'L') {
				int temp = idx+1;
				if (cur != next) cur = next;
				while (temp < s.length && s[temp] == 'L') {
					cur++;
					next++;
					temp++;
				}
				cur++;
				next++;
			}else if (s[idx] == 'L' && idx+1 < s.length) {// && s[idx+1] == 'L') {
				cur--;
			}
//			else if (s[idx] == 'L' && idx+1 < s.length && s[idx+1] == 'R') {
//				int temp = idx+1;
//				while (temp < s.length && s[temp] == 'R') {
//					cur--;
//					temp++;
//				}
//				cur--;
//			}
		}
		
		if (s[s.length-1] == 'R') {
			order.add(next+1);
		}else {
			order.add(cur-1);
		}
		
//		System.out.println(order);
		for (int i : order) {
			System.out.println(i);
		}
		
	}

}
/*

3
LR

6
RLLRL

6
RRRLL

*/