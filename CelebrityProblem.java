public class CelebrityProblem {
    /**
     * Time Complexity : O(n^2)
     * Space Complexity : O(2n)
     */
    static int celebrity(int mat[][]) {
        int[] iknow = new int[mat.length];
        int[] knowme = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i != j && mat[i][j] == 1) {
                    knowme[j]++;
                    iknow[i]++;
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (knowme[i] == mat.length - 1 && iknow[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
                {0, 1, 0},
                {0, 1, 1}};

        System.out.println(celebrity(mat));
    }
}
