import java.util.Arrays;

public class ConcanetedNonZeroandMultiply_II {

    static int[] sumAndMultiply(String s, int[][] queries) {

        int[] ans = new int[queries.length];
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < queries.length; i++) {

            StringBuilder sb = new StringBuilder();
            int sum = 0;

            left = queries[i][0];
            right = queries[i][1];

            for (int j = left; j <= right; j++) {
                if (s.charAt(j) != '0') {
                    sb.append(s.charAt(j));
                    sum += Character.getNumericValue(s.charAt(j));
                }
            }

            if (sb.isEmpty()) {
                ans[i] = 0;
            }else{
                int num = Integer.parseInt(sb.toString());
                ans[i] = num * sum;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String s = "10203004";
        int[][] queries = {{0, 7}, {1, 3}, {4, 6}};

        int[] ans = sumAndMultiply(s, queries);
        System.out.println(Arrays.toString(ans));

        
    }
}
