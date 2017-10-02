package hackerRank;

import java.util.Scanner;
import java.util.Vector;

public class SherlocksArray {

	public static long modulo = 1000000007;

	public static void main(String args[]) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] m = new int[n];
		for (int i = 0; i < n; i++) {
			m[i] = in.nextInt();
		}
		in.close();

		int first_sorted_subarray_length = 1;
		for (int i = 0; i + 1 < n; i++) {
			if (m[i] < m[i + 1]) {
				first_sorted_subarray_length++;
			} else {
				break;
			}
		}

		Vector<Integer> maxVector = new Vector<Integer>();
		int last = 0;
		int localMax = first_sorted_subarray_length;
		for (int i = 0; i < n - 1; i++) {
			last++;
			if (m[i] > m[i + 1] || last == localMax) {
				maxVector.add(last);
				last = 0;
				if (last < localMax) {
					localMax = last;
				}
			}
		}
		maxVector.add(last + 1);

		int[] maxArray = new int[maxVector.size()];
		for (int i = 0; i < maxVector.size(); i++) {
			maxArray[i] = maxVector.get(i);
		}

		int[] initialArray = new int[n - 1];
		initialArray[0] = 2;
		for (int i = 1; i < n - 1; i++) {
			initialArray[i] = 1;
		}

		long sum = recursiveCalculator(initialArray, maxArray, 0) + 1;
		System.out.println(sum % modulo);
	}

	private static long recursiveCalculator(final int[] initialArray, final int[] maxArray, int editableFrom) {

		if (checkValidity(initialArray, maxArray) == false)
			return 0;

		long localSum = calculateOverallPermutation(initialArray);

		if (initialArray.length == 1 || initialArray[initialArray.length - 1] != 1) {
			return localSum;
		}

		try {
			int index = initialArray.length - 1;
			while (true) {
				index = getNextIndex(initialArray, index, editableFrom);
				if (index < 0)
					break;

				int[] newArr = new int[initialArray.length - 1];
				for (int i = 0; i < newArr.length; i++) {
					newArr[i] = initialArray[i];
				}
				newArr[index] = newArr[index] + initialArray[initialArray.length - 1];
				// System.out.println("--------");
				// toString(initialArray);toString(newArr);System.out.println("--------");
				localSum = localSum + recursiveCalculator(newArr, maxArray, index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return localSum;
	}

	private static boolean checkValidity(final int[] initialArray, final int[] maxArray) {
		int[] copyMaxArray = new int[maxArray.length];
		for (int i = 0; i < maxArray.length; i++) {
			copyMaxArray[i] = maxArray[i];
		}

		int maxArrayIndex = 0;
		for (int i = 0; i < initialArray.length; i++) {
			int diff = copyMaxArray[maxArrayIndex] - initialArray[i];
			if (diff < 0) {
				return false;
			} else if (diff == 0) {
				maxArrayIndex++;
			} else {
				copyMaxArray[maxArrayIndex] = diff;
			}
		}

		return true;
	}

	private static int getNextIndex(int[] arr, int index, int editableFrom) {

		if (index == 0)
			return -1;

		int val = 0;
		for (int i = index - 1; i > 0; i--) {
			if (arr[i - 1] > arr[i]) {
				val = i;
				break;
			}
		}
		if (val >= editableFrom) {
			return val;
		} else {
			return -1;
		}
	}

	// private static int getSmallestIndexThatHasSmallestValue(final int[] arr)
	// {
	// int k = arr.length - 1;
	// for (int i = k; i > 0; i--) {
	// if (arr[i - 1] > arr[i]) {
	// return i;
	// }
	// }
	// return -1;
	// }

	private static long calculateOverallPermutation(final int[] array) {

		// toString(array);

		if (array.length == 1)
			return 1;

		long perm = 1;
		for (int i = 1; i < array.length; i++) {
			perm = perm * permutation(array[i - 1], array[i]);
			
			if (perm > modulo)
				return perm % modulo;
		}

		return perm;
	}

	private static long permutation(long n, long r) {
		if (r == 0)
			return 1;
		if (n == r)
			return factorialWithModulo(n);
		
		long val = permutation(n, r - 1) * (n - r + 1);
		
		if(val<0)
			throw new RuntimeException("Overflow");

		if (val > modulo)
			return val % modulo;

		return val;
	}

	private static long factorialWithModulo(long n) {
		if (n == 1)
			return 1;

		long val = n * factorialWithModulo(n - 1);
		
		if(val<0)
			throw new RuntimeException("Overflow");

		if (val > modulo)
			return val % modulo;

		return val;
	}

	private static void toString(final int[] array) {
		System.out.print("Array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
