import java.util.*;
public class F {
	public static void main(String[] aaarghs) {
		Scanner scan = new Scanner(System.in);
		int num_problems = scan.nextInt();
		int num =0;
		for (int p = 0; p < num_problems; p++) {
			int N = scan.nextInt();
			if (N==0) { 
				num = 0;
			}
			else {
				num = (N)*(N) + 2;
				for (int x1 = 1; x1 <= N; x1++) {
					for (int y1 = 1; y1 <= N; y1++) {
						if(find_smaller(x1,y1)) {
							num--;
						}
					}
				}
			}
			System.out.println((p+1)+" "+N+" "+num);
		}
	}
	public static boolean find_smaller(int x1, int y1) {
		for (int x2=1; x2 < x1; x2++) {
			for (int y2=1; y2 < y1; y2++) {
				if(x1*y2 - y1*x2 == 0) {
					return true;
				}
			}
		}
		return false;
	}
}
