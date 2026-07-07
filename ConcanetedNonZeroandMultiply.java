public class ConcanetedNonZeroandMultiply {

    static long sumAndMultiply(int n){
        String str = Integer.toString(n);
        long sum = 0;
        String concatenated = "";

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (ch != '0') {
                sum += Character.getNumericValue(ch);
                concatenated += ch;
            }
        }

        if(concatenated.length() == 0) {
            return 0;
        }else{
            n = Integer.parseInt(concatenated);
        }
        
        return n * sum;
    }
    public static void main(String[] args) {
        int n = 10203004;

        long ans = sumAndMultiply(n);
        System.out.println(ans);
    }
}
