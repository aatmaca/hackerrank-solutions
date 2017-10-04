package hackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// O(n) algorithm...
public class BeautifulTriplets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		int[] arr = new int[n];
		for (int a0 = 0; a0 < n; a0++) {
			arr[a0] = in.nextInt();
		}
		in.close();

		int[] lengthArr = new int[d];
		for (int a0 = 0; a0 < n; a0++) {
			lengthArr[arr[a0] % d] += 1;
		}

		Map<Integer, int[]> myMap = new HashMap<Integer, int[]>();
		for (int i = 0; i < d; i++) {
			if (lengthArr[i]>2) {
				myMap.put(i, new int[lengthArr[i]]);
			}
		}
		
		for (int a0 = 0; a0 < n; a0++) {
			int remainder = arr[a0] % d;
			int[] myArr = myMap.get(remainder);
			if (myArr == null) {
				continue;
			}
			int myArrLength = myArr.length;
			myArr[myArrLength-lengthArr[remainder]] = arr[a0];
			lengthArr[remainder] -= 1;
		}
		
		int counter = 0;
		for (int i = 0; i < d; i++) {
			int[] myArr = myMap.get(i);
			if (myArr == null) {
				continue;
			}
			
			for (int j = 0; j < myArr.length-2; j++) {
				if ((myArr[j+2]- myArr[j+1] == d) && (myArr[j+1]-myArr[j] == d)) {
					counter++;
				}
			}
		}
		System.out.println(counter);
	}
}
