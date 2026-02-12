import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        Solution obj = new Solution();
        System.out.println(obj.typeCast(d));
    }
}

class Solution {
    int typeCast(double d) {
        return (int) d;
    }
}
