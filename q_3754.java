class q_3754 {
    public long sumAndMultiply(int n) {
        long x = 0;
        long place = 1;
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                x += (long) digit * place;
                place *= 10;
                sum += digit;
            }
            n /= 10;
        }

        return x * sum;
    }
}