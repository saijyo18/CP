import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class q_1291 {
      public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        for (int len = 2; len <= 9; len++) {

            // Starting digit
            for (int start = 1; start <= 10 - len; start++) {

                int num = 0;
                int digit = start;

                for (int i = 0; i < len; i++) {
                    num = num * 10 + digit;
                    digit++;
                }

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
