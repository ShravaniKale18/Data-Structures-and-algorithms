package Recursion;


public class ReverseString {

    static String reverse_String(char[] ch, int start, int end) {

        if (start >= end) {
            return new String(ch);
        }

        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;

        return reverse_String(ch, start+1, end-1);

    }

    static boolean reverse_String2(char[] ch, int start, int end) {
        if(start >= end) {
            return true;
        }

        if(ch[start] != ch[end]) {
            return false;
        }

        return reverse_String2(ch, start+1, end-1);
    }
    public static void main(String[] args) {
        String s = "vhuihn";
        String original = s;

        char[] ch = s.toCharArray();

        String ans = reverse_String(ch, 0, s.length() - 1);
        System.out.println(ans);

        if (ans.equals(original)) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }

        boolean ans1 = reverse_String2(ch, 0, ch.length - 1);
        if (ans1) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}
