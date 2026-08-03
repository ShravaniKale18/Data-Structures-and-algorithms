public class LongestCommonPrefix {

    static String longestCommonPrefix(String[] strs) {

        String newStr = "";

        for (int i = 0; i < strs[0].length(); i++) {


            for (int j = 0; j < strs.length; j++) {

                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return newStr;
                }

            }
            newStr += strs[0].charAt(i);
        }
        return newStr;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix(strs));
    }
}
