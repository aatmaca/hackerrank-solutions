package hackerRank;

import java.util.Scanner;

public class TaumAndBday {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			long b = in.nextLong();
			long w = in.nextLong();
			long x = in.nextLong();
			long y = in.nextLong();
			long z = in.nextLong();

			boolean useOnlyBlacks = false, useOnlyWhites = false;
			if (x + z < y) {
				useOnlyBlacks = true;
			} else if (y + z < x) {
				useOnlyWhites = true;
			}

			if (useOnlyBlacks) {
				System.out.println(b * x + w * (x + z));
			} else if (useOnlyWhites) {
				System.out.println(b * (y + z) + w * y);
			} else {
				System.out.println(b * x + w * y);
			}

		}
		in.close();
	}
}
