import java.util.*;
import java.math.BigInteger;
public class Main {
	public static void main(String[] aarghs) {
		Scanner scan = new Scanner(System.in);
		int probs = scan.nextInt();
		for (int p = 0; p < probs; p++) {
			String seq = scan.next();
			String sub = scan.next();
			BigInteger[][] m = new BigInteger[sub.length()][seq.length()];
			for (int u = 0; u < sub.length(); u++) {
				for (int q = 0; q < seq.length(); q++) {
					BigInteger temp = BigInteger.ZERO;
					if (q != 0) temp = temp.add(m[u][q-1]);
					if (seq.charAt(q) == sub.charAt(u)) {
						if (u == 0) {
							temp = temp.add(BigInteger.ONE);
						}
						else if (q != 0) {
							temp = temp.add(m[u-1][q-1]);
						}
					}
					m[u][q] = temp;
				}
			}
			//for (int[] a : m) {
			//	System.out.println(Arrays.toString(a));
			//}
			System.out.println(m[m.length-1][m[0].length-1]);
		}
	}
}
