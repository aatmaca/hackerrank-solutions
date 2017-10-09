int castleTowers(int n, vector <int> ar) {
    int cnt = 0;
    int maxi = 0;
    for (int i = 0; i < n; i++) {
        if (ar[i] >= maxi) {
            if (ar[i] > maxi) {
                maxi = ar[i];
                cnt = 1;
            } else if (ar[i] == maxi) {
                cnt++;
            }
        }
    }
    return cnt;
}
