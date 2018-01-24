import java.util.Calendar;

/**
 * Created by zhoujun on 2017/5/23.
 */
public class Test001 {
    public static void main(String[] args) {
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        java.util.Date currTime = new java.util.Date();

        int year = currTime.getYear();//年

        int month = currTime.getMonth()+1;//月

        int week = currTime.getDay(); //星期几

        int day = currTime.getDate();//日
        System.out.println( "day "+ day);

        Calendar cal= Calendar.getInstance();
        cal.setTime(currTime);
        int day2 = cal.get(Calendar.DATE);

        System.out.println( "day2 "+ day2);

        String curTime = formatter.format(currTime);

    }
}
