public class q_3020 {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;


        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, cnt % 2 == 1 ? cnt : cnt - 1);
        }

        for (long start : freq.keySet()) {
            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                if (cur > 1_000_000_000L) break;

                cur *= cur;
            }

            if (freq.getOrDefault(cur, 0) >= 1) {
                len += 1;     
            } else {
                len -= 1;    
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}