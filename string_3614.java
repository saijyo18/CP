public class string_3614 {
    public static char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } else { // '%'
                len[i + 1] = len[i];
            }

            // Prevent overflow
            len[i + 1] = Math.min(len[i + 1], Long.MAX_VALUE / 2);
        }

        if (k < 0 || k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long before = len[i];
            long after = len[i + 1];

            if (ch >= 'a' && ch <= 'z') {
                if (k == before) {
                    return ch;
                }
            } else if (ch == '*') {
            } else if (ch == '#') {
                if (k >= before) {
                    k -= before;
                }
            } else { 
                k = before - 1 - k;
            }
        }

        return '.';
    }

    public static void main(String args[]){
        String str = "a#b%*";
        int k =1;
        char ch = processStr(str, k);
        System.out.println(ch);

    }
}