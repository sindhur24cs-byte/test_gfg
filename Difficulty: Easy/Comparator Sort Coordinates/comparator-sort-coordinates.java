import java.util.Arrays;
import java.util.Comparator;
class Solution {
    // Function to sort the array of Point objects
    public static void coordinatesSort(Point arr[]) {
        Arrays.sort(arr, new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                // Primary check: Sort by x in ascending order
                if (p1.x != p2.x) {
                    return p1.x - p2.x;
                }
                // Secondary check: If x values are equal, sort by y in ascending order
                return p1.y - p2.y;
            }
        });
    }
}