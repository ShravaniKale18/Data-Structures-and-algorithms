public class LongestPalindromeSubstring {
    
    public static String longestPalindrome(String s) {

        String longestPalindromeLengthString = "";

        // Generate Substrings
        for(int i = 0; i < s.length(); i++) {
            String subString = "";

            for(int j = i; j < s.length(); j++) {
                subString += s.charAt(j);
                
                if(isPalindrome(subString)) {
                    if(subString.length() > longestPalindromeLengthString.length()) {
                        longestPalindromeLengthString = subString; 
                    }
                }
            }
        }
        return longestPalindromeLengthString;
    }

    public static boolean isPalindrome(String s) {

        int i = 0;
        int j = s.length() - 1;

        while(i <= j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "babacd";
        String ans = longestPalindrome(s);
        System.out.println(ans);
    }
}
