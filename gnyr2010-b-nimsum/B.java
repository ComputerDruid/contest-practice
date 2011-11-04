import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int p = scan.nextInt();
		for (int i = 0; i < p; i++) {
			int n = scan.nextInt();
			int b = scan.nextInt();
			int x = scan.nextInt();
			int y = scan.nextInt();

			int out = 0;
			int place = 0;
			while (x > 0 || y > 0) {
				out += ((x + y) % b) * (int)Math.pow(b, place++);
				x /= b;
				y /= b;
			}
			System.out.println(n + " " + out);
		}
	}
}
