import java.util.*;
public class C {
	public static void main(String [] aarghs) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			int length = scan.nextInt();
			String s1 = scan.next();
			String s2 = scan.next();
			String out = scan.next();
			String found = "";
			HashSet<String> s = new HashSet<String>();
			int pos = 0;
			do {
				found = shuffle(s1,s2);
				if (s.contains(found)) {
					pos = -1;
					break;
				}
				s.add(found);
				pos ++;
				s1 = found.substring(0, length);
				s2 = found.substring(length, 2*length);
			} while( !out.equals(found) );
			System.out.println((i+1) +" "+ pos);
		}
	}
	public static String shuffle(String s1, String s2) {
		String out = "";
		for (int i = 0; i < s1.length();i++) {
			out = out + s2.charAt(i) + s1.charAt(i);
		}
		return out;
	}
}
