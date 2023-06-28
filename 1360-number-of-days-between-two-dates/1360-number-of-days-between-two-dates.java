class Solution {
    private int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(dayCountFrom1970(date1) - dayCountFrom1970(date2));
    }
    
    public int dayCountFrom1970(String date){
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        int dayCount = day;

        for(int y = 1970; y < year; y++){
            dayCount += 365;
            if(isLeapYear(y)) dayCount += 1; // is Leap Year?
        }
        
        for(int m = 0; m < month - 1; m++){
            dayCount += months[m];
            if(m == 1 && isLeapYear(year)) dayCount += 1; // is Leap Year?
        }
        
        return dayCount;
    }
    
    private boolean isLeapYear(Integer year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}