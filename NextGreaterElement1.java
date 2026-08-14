import java.util.Arrays;

public class NextGreaterElement1 {
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int pos = -1;
        int[] newArr = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            boolean found = false;

            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    pos = j;

                    for (int k = pos + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            newArr[i] = nums2[k];
                            found = true;
                            break;
                        }
                    }
                }else{
                    // newArr[index++] = -1;
                    continue;
                }
            }

            if (!found) {
                newArr[i] = -1;
            }
        }

        

        return newArr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};


        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
