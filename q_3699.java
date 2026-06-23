public class q_3699{
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 1];
        long[] down = new long[m + 1];

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1;
            down[v] = m - v;
        }
        for (int len = 3; len <= n; len++) {
            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];
            long prefix = 0;
            for (int x = 1; x <= m; x++) {
                newUp[x] = prefix;
                prefix = (prefix + down[x]) % MOD;
            }

            long suffix = 0;
            for (int x = m; x >= 1; x--) {
                newDown[x] = suffix;
                suffix = (suffix + up[x]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        } else {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        }

        return (int) ans;
    }
}