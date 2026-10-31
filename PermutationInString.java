public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] count1 = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            int index = ch - 'a';
            count1[index]++;
        }

        int i = 0;
        int windowLength = s1.length();
        int[] count2 = new int[26];

        for(i = 0; i < windowLength; i++) {
            char ch = s2.charAt(i);
            int index = ch - 'a';
            count2[index]++;
        }

        if(compareFreq(count1, count2) == true) {
            return true;
        }

        for(int j = windowLength; j < s2.length(); j++) {

            // Add incoming character
            char newChar = s2.charAt(j);
            count2[newChar - 'a']++;

            // Remove outgoing character
            char oldChar = s2.charAt(j - windowLength);
            count2[oldChar - 'a']--;

            if(compareFreq(count1, count2)) {
                return true;
            }
        }

        return false;

    }

    public static boolean compareFreq(int[] count1, int[] count2) {
        for(int i = 0; i < 26; i++) {
            if(count1[i] != count2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));

    }
}
