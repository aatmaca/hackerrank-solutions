package hackerRank;

import java.util.BitSet;
import java.util.Scanner;

public class ACM_ICPC_Team {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		BitSet[] array = new BitSet[n];

		for (int a0 = 0; a0 < n; a0++) {
			BitSet bs = new BitSet(k);
			String bits = in.next();
			for (int i = 0; i < k; i++) {
				if (bits.charAt(i) == '1') {
					bs.set(i);
				}
			}
			array[a0] = bs;
		}
		in.close();
		
		int max = 0;
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				BitSet clone = (BitSet) array[i].clone();
				clone.or(array[j]);
				int cardinality = clone.cardinality();
				if (cardinality == max) {
					counter++;
				} else if(cardinality > max){
					max = cardinality;
					counter = 1;
				}
			}
		}
		System.out.println(max);
		System.out.println(counter);
	}

}
