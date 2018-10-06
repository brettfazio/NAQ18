import java.util.Scanner;

public class k {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean encode = sc.next().charAt(0) == 'E';
		
		String s = sc.next();
		
		if (encode) {
			
			String oo = "";
			for (int i =0; i < s.length(); i++) {
				int cnt = 1;
				char base = s.charAt(i);
				while (i+1 < s.length() && s.charAt(i+1)==base) {
					cnt++;
					i++;
				}
//				if (cnt != 0) cnt--;
				
					oo += base;
					oo += cnt;
			}
			
			System.out.println(oo);
			
		}else {
			//decode
			
			String ALL_NUMS = "0123456789";
			String oo = "";
			for (int i = 0; i < s.length(); i++) {
				if (ALL_NUMS.contains(""+s.charAt(i))) continue;
				if (i+1 < s.length() && ALL_NUMS.contains(""+s.charAt(i+1))) {
					int parse = Integer.parseInt(""+s.charAt(i+1));
					for (int j = 0; j < parse; j++) {
						oo += s.charAt(i);
					}
				}else {
					oo += s.charAt(i);
				}
			}
			
			System.out.println(oo);
		}
	}

}

/*


*/
