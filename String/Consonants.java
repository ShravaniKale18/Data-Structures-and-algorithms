package String;

public class Consonants {
    public static void main(String[] args) {
        String s = "Shravani";
        int countVowels = 0;
        int countConsonants = 0;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'o' || ch == 'i' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                countVowels++;
            }else{
                countConsonants++;
            }
        }

        System.out.println("Consonants = "+countConsonants);
        System.out.println("Vowels = "+countVowels);
    }
}
