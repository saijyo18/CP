public class q_1967 {

    public static int wordcount(String arr[], String word){
        int count =0;
        for(String str: arr){
            if(word.contains(str)){
                count++;
            }
        }

        return count;
        
    }
    public static void main(String args[]){
        String arr[] = {"a","b","c"};
        int count = wordcount(arr, "aaaaabbbbb");
        System.out.println(count);
    
    }
}
