import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoujun on 2017/10/14.
 */
public class Test {

    public static void main(String[] args) {

        TT s = new TT();

        List<String> ls =  s.getList();

        ls = new ArrayList<>();
        ls.add("1");

        s.getList().forEach(r -> System.out.println(r));






    }



}
