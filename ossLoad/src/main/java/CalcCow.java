/**
 * Created by zhoujun on 2017/8/15.
 */
public class CalcCow {
    public static void main(String[] args) {
        System.out.println("=======我的算法");
        for (int i = 1; i < 16; i++)
            System.out.println("第" + i + " 年:" + fn(i));

        System.out.println("=======网上算法");
        for (int i = 1; i < 15; i++) {
            System.out.print(i + "年后有牛：");
            System.out.println(countCow(i));
        }
    }

    public static int fn(int year) {
        if (year < 3)
            return 1;
        int sum = 1;
        for (int i = year - 3; i > 0; i--) {
            sum += fn(i);
        }
        return sum;
    }

    public static int countCow(int temp) {
        if (temp <= 2)
            return 1;
        if (temp == 3)
            return 2;
        else
            return countCow(temp - 1) + countCow(temp - 3);
    }


}

