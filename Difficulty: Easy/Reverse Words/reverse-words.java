import java.util.*;

class Solution {
    public static String reverseWords(String s) {

        String arr[] = s.split("\\.");
        String result = "";

        for(int i = arr.length - 1; i >= 0; i--) {
            if(!arr[i].equals("")) {
                if(result.length() == 0)
                    result = arr[i];
                else
                    result = result + "." + arr[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "..geeks..for.geeks.";
        System.out.println(reverseWords(s));
    }
}