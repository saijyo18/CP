class q_3756 {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] digitPrefix = new int[n + 1];
        int[] nzPrefix = new int[n + 1];

        int totalNZ = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            digitPrefix[i + 1] = digitPrefix[i] + d;
            nzPrefix[i + 1] = nzPrefix[i] + (d != 0 ? 1 : 0);
            if (d != 0) totalNZ++;
        }

        long[] pow10 = new long[totalNZ + 1];
        pow10[0] = 1;
        for (int i = 1; i <= totalNZ; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        long[] hash = new long[totalNZ + 1];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            if (d != 0) {
                idx++;
                hash[idx] = (hash[idx - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitPrefix[r + 1] - digitPrefix[l];

            int leftNZ = nzPrefix[l];
            int rightNZ = nzPrefix[r + 1];
            int len = rightNZ - leftNZ;

            long x;
            if (len == 0) {
                x = 0;
            } else {
                x = (hash[rightNZ] - hash[leftNZ] * pow10[len]) % MOD;
                if (x < 0) x += MOD;
            }

            ans[i] = (int) ((x * sum) % MOD);
        }

        return ans;
    }
}