package String;

public class ConvertUpperCase {
    public static void main(String[] args) {
        String s = "Shrava";
        String newString = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                newString += (char)(ch-'a'+'A');
            }
        }

        System.out.println(newString);
    }
}
