import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        
        int number = Integer.parseInt(num);  // Typecast String to int
        number = 2 * number;                // Double it
        
        System.out.println(number);
    }
}
