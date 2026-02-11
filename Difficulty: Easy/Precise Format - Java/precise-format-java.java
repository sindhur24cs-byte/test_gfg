import java.util.*;

class Solution {
    static ArrayList<Float> divisionWithPrecision(float a, float b) {

        ArrayList<Float> result = new ArrayList<>();

        float exact = a / b;
        float rounded = Float.parseFloat(String.format("%.3f", exact));

        result.add(exact);
        result.add(rounded);

        return result;
    }
}
