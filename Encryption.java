package hackerRank;

import java.util.Scanner;

public class Encryption {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		in.close();

		int length = str.length();

		int sqrt = (int) Math.sqrt(length);

		int row = sqrt;
		int column;
		if (sqrt * sqrt == length) {
			column = sqrt;
		} else {
			column = sqrt + 1;
		}

		if (row * column < length) {
			row++;
		}

		char[][] M = new char[row][column];
		int charCounter = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (charCounter < length) {
					M[i][j] = str.charAt(charCounter);
				} else {
					break;
				}
				charCounter++;
			}
		}

		int lastLineCharCount = column - (row * column - length);

		String res = "";
		int counterForLastLine = 0;
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row - 1; j++) {
				res = res.concat(M[j][i] + "");
			}
			if (counterForLastLine < lastLineCharCount) {
				res = res.concat(M[row - 1][i] + "");
				counterForLastLine++;
			}

			if (i < column - 1)
				res = res.concat(" ");
		}
		System.out.print(res);
	}

}
