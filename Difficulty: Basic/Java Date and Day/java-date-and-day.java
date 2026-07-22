import java.time.LocalDate;

class Solution {
    public static String findDay(int Date, int Month, int Year) {
        // LocalDate.of accepts Year, Month, Day in order
        LocalDate date = LocalDate.of(Year, Month, Date);
        
        // getDayOfWeek().name() returns uppercase string like "FRIDAY", "MONDAY"
        return date.getDayOfWeek().name();
    }
}