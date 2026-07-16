class q_3867 {
    public long gcdSum(int[] nums) {
        int max[] = new int[nums.length];
        int pregcd[] = new int[nums.length];

        // make the max arrays 
        max[0] = nums[0];
        for(int i=1; i< nums.length ; i++){
            max[i] = Math.max(max[i-1], nums[i]);
        } 

        for(int i=0 ; i < pregcd.length ; i++){
            pregcd[i] = gcd(nums[i], max[i]);
        }

        // sort
        Arrays.sort(pregcd);
        int lp =0; int rp = pregcd.length -1;
        long sum =0;
        while( lp < rp){
            sum += gcd(pregcd[lp], pregcd[rp]);
            lp++; rp--;
        }


        return sum;


    }

    public static int gcd(int num1, int num2){
        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}