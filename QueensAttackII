package hackerRank;

import java.util.Scanner;
import java.util.Vector;

public class QueensAttack {
	
	static class Pair {
	      int row;
	      int column;
	      public Pair(int r, int c){
	    	  row = r;
	    	  column = c;
	      }
	   }

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();
		int reversedRowQueen = n + 1 - rQueen;

		Vector<Pair> colObstacles = new Vector<Pair>();
		Vector<Pair> rowObstacles = new Vector<Pair>();
		Vector<Pair> leftBottomToRightTopObstacles = new Vector<Pair>();
		Vector<Pair> leftTopToRightBottomObstacles = new Vector<Pair>();

		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();

			if (cObstacle == cQueen) {
				colObstacles.add(new Pair(rObstacle, cObstacle));
			} else if (rObstacle == rQueen) {
				rowObstacles.add(new Pair(rObstacle, cObstacle));
			} else if (rObstacle - cObstacle == rQueen - cQueen) {
				leftBottomToRightTopObstacles.add(new Pair(rObstacle, cObstacle));
			} else if (n + 1 - rObstacle - cObstacle == reversedRowQueen - cQueen) {
				leftTopToRightBottomObstacles.add(new Pair(n + 1 - rObstacle, cObstacle));
			}
		}
		in.close();

		// The number of squares the queen can attack from her position
		long sum = 0;

		// Column
		int low = 0, high = n + 1;
		for (Pair obstacle : colObstacles) {

			int row = obstacle.row;

			if (row < rQueen) {
				if (row > low)
					low = row;
			} else {
				if (row < high)
					high = row;
			}
		}
		sum += high - low - 2;
//		System.out.println(sum);

		// Row
		low = 0;
		high = n + 1;
		for (Pair obstacle : rowObstacles) {

			int column = obstacle.column;

			if (column < cQueen) {
				if (column > low)
					low = column;
			} else {
				if (column < high)
					high = column;
			}
		}
		sum += high - low - 2;
//		System.out.println(sum);

		// leftBottomToRightTop
		low = 0;
		high = n + 1;
		int dif = rQueen - cQueen;
		if (dif > 0 ) {
			high -= dif;
		} else {
			low -=dif; // Remember that dif is a negative number. So we subtract to add absolute value of dif.
		}
		for (Pair obstacle : leftBottomToRightTopObstacles) {

			int row = obstacle.row;
			int column = obstacle.column;

			if (rQueen > row) {
				if (column > low)
					low = column;
			} else {
				if (column < high)
					high = column;
			}
		}
		sum += high - low - 2;
//		System.out.println(sum);

		// leftTopToRightBottom
		low = 0;
		high = n + 1;
		dif = reversedRowQueen - cQueen;
		if (dif > 0 ) {
			high -= dif;
		} else {
			low -=dif; // Remember that dif is a negative number. So we subtract to add absolute value of dif.
		}
		for (Pair obstacle : leftTopToRightBottomObstacles) {

			int row = obstacle.row;
			int column = obstacle.column;

			if (reversedRowQueen > row) {
				if (low < column)
					low = column;
			} else {
				if (column < high)
					high = column;
			}
		}
		sum += high - low - 2;

		System.out.println(sum);
	}
}
