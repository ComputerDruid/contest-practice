import java.util.*;
public class main {
	public static void main(String[] aaarghs) {
		Scanner scan = new Scanner(System.in);
		int L = scan.nextInt();
		while(L != 0) {
			int N = scan.nextInt();
			int[] a = new int[N + 1];
			for (int i = 0; i < N i++) {
				a[i] = scan.nextInt();
			}
			a[N] = l;

			System.out.println(cost(a, 0, a.length, l);
			L = scan.nextInt();
		}
	}
	public static void cost(int [] a, int min, int max, int length) {
		if (min == max) return length;
		int offset = a[max] - length;
		int pos = offset;
		int best_idx = min;
		for (int idx = min; idx < max; idx++) {
			if ( a[idx] - offset < length/2.0) {
				pos = a[idx];
				best_idx = idx;
			}
			else {
				if (a[idx] - (length/2 + offset) < (length/2 + offset) - pos) {
					pos = a[idx];
					best_idx = idx;
				}
				break;
			}
		}
	}
}
