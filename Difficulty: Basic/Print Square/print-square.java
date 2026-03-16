class Solution {
    public static void square(int s) {

        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= s; j++) {

                if (i == 1 || i == s || j == 1 || j == s) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }

    }
}