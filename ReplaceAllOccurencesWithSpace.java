public class ReplaceAllOccurencesWithSpace {

    public static String replace(String s, String sub) {

        s = s.replace(sub, " ");
            
        return s.trim();
    }

    public static void main(String[] args) {
        String s = "LIELIEILIEAMLIECOOL";
        String sub = "LIE";

        System.out.println(replace(s, sub));
    }
}
