#include <iostream>
using namespace std;
#include <map>

//void printArray(int array[], int numElements);

int collatzSequenceLen(int n, map<int, int> &collatzResult) {
	if (n == 0) {
		return 0;
	}
	if (collatzResult[n] != 0) {
		return collatzResult[n];
	}
	if (n % 2 == 0) {
		int c = collatzSequenceLen(n / 2, collatzResult);
		collatzResult[n] = 1 + c;
		return 1 + c;
	}
	int c = collatzSequenceLen(3 * n + 1, collatzResult);
	collatzResult[n] = 1 + c;
	return 1 + c;
}

int collatzSequenceSum(int T, int A, int B) {
	std::map<int, int> collatzResult;
	collatzResult[0] = 0;
	collatzResult[1] = 1;

	int n = 0;
	int tNumbers[T];
	int max = 0;
	for (int i = 0; i < T; i++) {
		n = (A * n + B) % 5003;
		tNumbers[i] = n;
		if (n > max) {
			max = n;
		}
	}

	int best_num_array[max+1];
	int best_len = 0;
	int best_num = 0;
	for (int k = 0; k <= max; ++k) {
		int cur_len = collatzSequenceLen(k, collatzResult);
		if (cur_len >= best_len) {
			best_len = cur_len;
			best_num = k;
		}
		best_num_array[k] = best_num;
	}

	int result = 0;
	for (int i = 0; i < T; i++) {
		result += best_num_array[tNumbers[i]];
	}
	return result;
}

//void printArray(int array[], int numElements){
//	for (int i = 0; i<numElements; i++)
//	    cout << array[i];
//	cout << endl;
//}

int main() {
	int T;
	int A;
	int B;
	cin >> T >> A >> B;
	int result = collatzSequenceSum(T, A, B);
	cout << result << endl;
	return 0;
}
