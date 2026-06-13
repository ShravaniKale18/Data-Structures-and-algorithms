package String;

public class Removespaces {
    public static void main(String[] args) {
        String s = "        shravani       ";

        // for (int i = 0; i < s.length(); i++) {
        //     char ch = s.charAt(i);
        //     if (ch == ' ') {
        //         s = s.replace(" ", "");
        //     }
        // }

        s = s.replace(" ", "");

        System.out.println(s);
    }
}
