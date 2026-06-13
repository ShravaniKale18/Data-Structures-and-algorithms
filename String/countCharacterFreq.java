package String;

public class countCharacterFreq {

    static int countFrequency(String s, char ch) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ch) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaaabbbsssaaacc";

        int ans = countFrequency(s, 'a');
        System.out.println(ans);
    }
}
