package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class LeaderArray {
    public static void findLeaders(ArrayList<Integer> elements) {
		ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < elements.size(); j++) {
                if (elements.get(j) > elements.get(i)) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                list.add(elements.get(i));
            }
        }
        System.out.println(list);
	}
    public static void main(String[] args) {
        ArrayList<Integer> elements = new ArrayList<>(Arrays.asList(10, 22, 13, 6, 0, 3));
        findLeaders(elements);
    }
}
