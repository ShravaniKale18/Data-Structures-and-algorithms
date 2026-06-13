package String;

class CountWords {
    public static void main(String[] args) {
        String str = " Hello, my name is shravani i am from latur";
        str = str.trim();
        
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println("Total number of words = "+(count+1));
    }
}
