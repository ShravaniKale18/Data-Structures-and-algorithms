package String;

public class CheckDigits {
    public static void main(String[] args) {
        String s = "123juqgbu456";
        boolean ans = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) {
                ans = false;
                break;
            }
        }

        if (ans) {
            System.out.println("contains only digit");
        }else{
            System.out.println("Contains characters as well");
        }
    }
}
