import java.util.*;

public class q_3737{
    static class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 1];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> rank = new HashMap<>();
        int id = 1;

        for (long x : sorted) {
            if (!rank.containsKey(x)) {
                rank.put(x, id++);
            }
        }

        Fenwick bit = new Fenwick(id);
        long ans = 0;

        for (long p : prefix) {
            int r = rank.get(p);

            // count previous prefix sums < current prefix sum
            ans += bit.query(r - 1);

            bit.update(r, 1);
        }

        return (int) ans;
    }
}