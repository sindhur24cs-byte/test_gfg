import java.util.TreeSet;

class gfg1 {
    public static void task(TreeSet<String> ts, char a, char b, char c, char d) {
        // Convert char parameters to String to match TreeSet elements
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        String strC = String.valueOf(c);
        String strD = String.valueOf(d);

        // 1. Strings strictly less than 'a'
        System.out.println(ts.headSet(strA));

        // 2. Strings greater than or equal to 'b'
        System.out.println(ts.tailSet(strB));

        // 3. Strings between 'c' (inclusive) and 'd' (exclusive)
        System.out.println(ts.subSet(strC, strD));
    }
}