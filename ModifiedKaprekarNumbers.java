package hackerRank;

import java.util.Scanner;

public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long p = in.nextLong();
		long q = in.nextLong();
		in.close();
		
		String result = "";
		for (long i = p; i <= q; i++) {
			String squareStr = i*i + "";
			int length = squareStr.length();
			
			if(length == 1){
				if(i == 1){
					result += i + " ";
				}
				continue;
			}
			
			int leftHalfLength = length/2;
			long left = Long.parseLong(squareStr.substring(0, leftHalfLength));
			long right = Long.parseLong(squareStr.substring(leftHalfLength));
			
			if(left + right == i){
				result += i + " ";
			}
		}
		
		if (result.length() > 0) {
			System.out.println(result.trim());
		} else {
			System.out.println("INVALID RANGE");
		}
	}
}
