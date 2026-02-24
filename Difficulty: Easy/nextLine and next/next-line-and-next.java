import java.util.*;

class Geeks {
    static void getInput() {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();   // number of testcases
        sc.nextLine();          // clear buffer

        while (t-- > 0) {
            int a = sc.nextInt();
            sc.nextLine();      // clear leftover newline

            String s = sc.nextLine();  // take full line with spaces

            System.out.println(a);
            System.out.println(s);
        }
    }
}