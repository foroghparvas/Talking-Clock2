import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class TalkingClock {
    private static  String[] digitToTwelve = { "zero", "one", "two", "three", "four", "five", "six", "seven",
            "eight", "nine", "ten", "eleven", "twelve" };
    private static  String[] teens = { "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen" };
    private static  String[] twentyToFifty = { "twenty", "thirty", "forty", "fifty"};

    private static  String startwith = "It's";

    private static String[] splitTime(String time) {
        if (time == null) {
            throw new IllegalArgumentException("The input time must not be null");
        }
        String[] timeSplitArray = time.split(":");
        if (timeSplitArray.length != 2) {
            throw new IllegalArgumentException("The input time must be in format \"HH:MM\"");
        }
        return timeSplitArray;
    }

    public static String hourToWords(String hourString) {
        int hour = Integer.parseInt(hourString);

        String amOrPm = "am";
        if (hour > 11) {
            amOrPm = "pm";
        }


        if (hour > 12) {
            hour = hour - 12;
        }
        if (hour == 0) {
            hour = 12;
        }

        String hourInWords = digitToTwelve[hour] + " " + amOrPm;
        return hourInWords;
    }

    public static String minutesToWords(String minString) {
        int minutes = Integer.parseInt(minString);
        String minutesString = "";
        if (minutes == 0) {
            return "";
        } else if (minutes < 10) {
            minutesString = "oh " + digitToTwelve[minutes];
        } else if (minutes < 13) {
            minutesString = digitToTwelve[minutes];
        } else if (minutes < 20) {
            minutesString = teens[minutes - 13];
        } else if ((minutes % 10) == 0) {
            minutesString = twentyToFifty[Math.floorDiv(minutes, 20)];



        } else {
            minutesString = twentyToFifty[(minutes/10) - 2] + " " + digitToTwelve[(minutes % 10)];

        }
        return minutesString;
    }



    public static String timeToWords(String time) {

        String[] parsedTime = splitTime(time);
        //System.out.println("current time in method is: " + Arrays.toString(parsedTime));
        String[] hourWithAmOrPm = hourToWords(parsedTime[0]).split(" ");
        String hour = hourWithAmOrPm[0];

        String suffix = hourWithAmOrPm[1];


        String minutes = minutesToWords(parsedTime[1]);
        if ("".equals(minutes)) {
            return startwith + " " + hour + " " + suffix;
        } else {
            return startwith + " " + hour + " " + minutes + " " + suffix ;
        }

    }

    public static void main(String[] args) {


        LocalDateTime myDate = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
        String strDate1 = myDate.format(df);
        System.out.println(strDate1);

        String[] timee = new String[]{strDate1};

        for (String time : timee) {

            System.out.println(timeToWords(time));
        }


    }

}
