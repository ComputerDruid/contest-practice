import java.util.*;

public class C {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int p = scan.nextInt();
		for (int q = 0; q < p; q++) {
			int n = scan.nextInt();
			int n_bytes = scan.nextInt();

			String hex = scan.next();
			while (hex.length() < n_bytes*2) {
				hex += scan.next();
			}
			
			int data[] = new int[n_bytes];
			for (int i = 0; i < n_bytes; i++) {
				data[i] = Integer.parseInt(hex.substring(2*i, 2*(i+1)), 16);
			}

			ArrayList<Integer> runs = new ArrayList<Integer>();
			ArrayList<Integer> vals = new ArrayList<Integer>();
			ArrayList<Integer> position = new ArrayList<Integer>();
			int currentRun = data[0];
			int currentRunLength = 1;
			for (int i = 1; i < n_bytes; i++) {
				if (data[i] == currentRun && currentRunLength < 130) {
					currentRunLength++;
				} else {
					if (currentRunLength > 2) {
					  runs.add(currentRunLength);
					  vals.add(currentRun);
					  position.add(i - currentRunLength);
					}
					currentRunLength = 1;
					currentRun = data[i];
				}
			}
		    if (currentRunLength > 2) {
			  runs.add(currentRunLength);
			  vals.add(currentRun);
			  position.add(n_bytes - currentRunLength);
			}

			String compressed = "";
			int run_index = 0;
			for (int i = 0; i < n_bytes; i++) {
              if (run_index < position.size() && i == position.get(run_index)) {
				  i += runs.get(run_index) - 1;
				  int length = 128 + runs.get(run_index) - 3;
				  String length_str = Integer.toHexString(length);
				  if (length_str.length() < 2) length_str = "0" + length_str;
				  compressed += length_str;
				  compressed += hex.substring(2*i, 2*(i+1));
				  run_index++;
			  } else {
                int non_run_length = 0;
				if (run_index < position.size()) {
					non_run_length = position.get(run_index) - i;
				} else {
                    non_run_length = n_bytes - i;
				}
				if (non_run_length > 128) non_run_length = 128;
				String length_str = Integer.toHexString(non_run_length-1);
				if (length_str.length() < 2) length_str = "0" + length_str;
				compressed += length_str;
				compressed += hex.substring(2*i, 2*i + 2 *non_run_length);
				i += non_run_length - 1;
			  }
			}
			System.out.println(n + " " + compressed.length()/2);
			for (int i = 0; i < compressed.length(); i += 80)
			  System.out.println(compressed.substring(i, Math.min(compressed.length(), i+80)).toUpperCase());
		}
	}
}
