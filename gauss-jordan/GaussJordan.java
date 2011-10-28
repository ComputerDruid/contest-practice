import java.util.Arrays;

public class GaussJordan {
	public static final double EPS = .000001;
	public static double[][] ref(double[][] m) {
		if (m.length == 0) return new double[0][0];
		int R = m.length;
		int C = m[0].length;
		int offset = 0;
		double[][] result = new double[R][C];

		for (int r = 0; r < R; r++)
			result[r] = m[r].clone();

		for (int c = 0; c < C; c++) {
			for (int r = c - offset; r < R; r++) {
				if (Math.abs(result[r][c]) > EPS) {
					scale_row(result[r], 1.0/result[r][c]);
					swap_rows(result, r, c - offset);
					for (int rr = 0; rr < R; rr++) {
						if (rr != r)
							kill_with_pivot(result, rr, r, c);
					}
					offset--; //don't increment offset
					break;
				}
			}
			offset++; //increment offset
		}
		return result;
	}


	public static void scale_row(double[] r, double a) {
		for (int c = 0; c < r.length; c++)
			r[c] *= a;
	}


	public static void swap_rows(double[][] m, int r1, int r2) {
		double[] temp = m[r1];
		m[r1] = m[r2];
		m[r2] = temp;
	}


	public static void kill_with_pivot(double[][] m, int r, int pivot_row, int pivot_col) {
		if (Math.abs(m[r][pivot_col]) > EPS) {
			double scale = - m[r][pivot_col] / m[pivot_row][pivot_col];
			for (int c = 0; c < m[r].length; c++) {
				m[r][c] += scale * m[pivot_row][c];
			}
		}
	}


	public static String mToString(double[][] m) {
		String temp = "";
		for (double[] row : m) {
			temp += Arrays.toString(row) + "\n";
		}
		return temp;
	}


	public static double [][] T(double[][] m) {
		double [][] result = new double[m[0].length][m.length];
		for (int r = 0; r < m.length; r++) {
			for (int c = 0; c < m[0].length; c++) {
				result[c][r] = m[r][c];
			}
		}
		return result;
	}
	public static void main (String[] aaaarghs) {
		double[][] A = {{1,1,1,6},{1,-1,1,2},{5,-1,-1,0}};
		System.out.print(mToString(T(A)));
		System.out.print(mToString(ref(T(A))));
	}
}
