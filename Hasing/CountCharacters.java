package Hasing;

import java.util.HashMap;
import java.util.Scanner;

public class CountCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        char[] ch = s.toCharArray();

        // int[] hash = new int[256];

        // for (int i = 0; i < s.length(); i++) {
        //     hash[ch[i]] += 1;
        // }

        // int q;
        // q = sc.nextInt();

        // while (q-- >= 0) {
        //     char c; 
        //     c = sc.next().charAt(0);
        //     System.out.println(hash[c]);
        // }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : ch) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        System.out.println(map);
        sc.close();
    }
}
