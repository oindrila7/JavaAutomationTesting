//Find the date difference (year, day, hour, min, sec) between your birthdate and today



package array_java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Prob_1 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss aa");
        Date dateToday = new Date();
        long presentDateTimeStamp = dateToday.getTime();
        String birthday = "16-08-1994 04:00:00 PM";
        Date convertedBirthday = sdf.parse(birthday);
        long birthdayTimeStamp = convertedBirthday.getTime();
        long currAge = presentDateTimeStamp - birthdayTimeStamp;
        long yr = currAge / (1000l * 365 * 24 * 60 * 60);
        long day = currAge / (1000l * 24 * 60 * 60) % 365;
        long hr = (currAge / (1000l * 60 * 60)) % 24;
        long min = (currAge / (1000l * 60)) % 60;
        long sec = (currAge / 1000l) % 60;
        System.out.println("Year difference: " + yr);
        System.out.println("Day difference: " + day);
        System.out.println("Hour difference: " + hr);
        System.out.println("Minute difference: " + min);
        System.out.println("Second difference: " + sec);
    }
}
