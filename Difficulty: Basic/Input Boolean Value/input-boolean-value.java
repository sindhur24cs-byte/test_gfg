import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextBoolean()) {
            boolean a = sc.nextBoolean();
            if (a) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        sc.close();
    }
}