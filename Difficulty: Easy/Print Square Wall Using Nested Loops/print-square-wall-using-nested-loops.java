class Solution {
    void squareWall(int S) {
        for (int i = 1; i <= S; i++) {
            for (int j = 1; j <= S; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}