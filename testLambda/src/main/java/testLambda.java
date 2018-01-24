import org.junit.Test;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by zhoujun on 2017/8/13.
 */
public class testLambda {

    public static void main(String[] args) {


    }

    @Test
    public void foreachTest() {

        List<String> names = new ArrayList();
        names.add("lucy");
        names.add("lily");
        names.add("ted");
        names.add("jim");
        names.add("cele");
        names.add("tom");

        System.out.println("--------------------------------------------");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("--------------------------------------------");

        final List<String> uppercaseNames = new ArrayList<String>();
        for (String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);

        System.out.println("--------------------------------------------");

        final List<String> startsWithL = new ArrayList<String>();
        for (String name : names) {
            if (name.startsWith("l")) {
                startsWithL.add(name);
            }
        }

        System.out.println("--------------------------------------------");
        System.out.println("--------------------------------------------");

    }

    @Test
    public void foreachTest2() {
        //asList()返回的是arrays中私有的终极ArrayList类型，它有set,get，contains方法，但没有增加和删除元素的方法，所以大小固定
        List<String> names = Arrays.asList("lucy", "lily", "ted", "jim", "cele", "tom");

        System.out.println("--------------------------------------------");
        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        names.forEach(record -> System.out.println(record));

        names.forEach(System.out::println);

        System.out.println("--------------------------------------------");
        final List<String> uppercaseNames = new ArrayList<String>();
        names.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println(uppercaseNames);

        names.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));
        System.out.println();

        names.stream()
                .map(String::toUpperCase)
                .forEach(name -> System.out.println(name));


        System.out.println("--------------------------------------------");
        final List<String> startsWithl = names.stream()
                .filter(name -> name.startsWith("l"))
                .collect(Collectors.toList());
        System.out.println(startsWithl);

        /**
         * Lambda表达式的重用
         比如，当需要对不止一个集合进行操作时：
         final long countFriendsStartN = friends.stream().filter(name -> name.startsWith("N")).count();
         final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();
         final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
         显而易见，Lambda表达式需要被重用。我们可以将Lambda表达式给保存到一个变量中，就像Java处理其他任何类型的变量一样。问题来了？Lambda表达式的类型是什么呢，在Java这种静态类型语言中，我们不能单单使用诸如var，val就来代表一个Lambda表达式。
         对于filter方法接受的Lambda表达式，它是符合Predicate接口类型的，因此可以声明如下：
         final Predicate<String> startsWithN = name -> name.startsWith("N");
         final long countFriendsStartN = friends.stream().filter(startsWithN).count();
         final long countComradesStartN = comrades.stream().filter(startsWithN).count();
         final long countEditorsStartN = editors.stream().filter(startsWithN).count();

         final Function<String, Predicate<String>> startsWithLetter =
         (String letter) -> {
         Predicate<String> checkStartsWith = (String name) -> name.startsWith(letter);
         return checkStartsWith;
         };

         final Function<String, Predicate<String>> startsWithLetter = (String letter) -> (String name) -> name.startsWith(letter);
         final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);
         两种类型的函数式接口(Functional Interface)
         Predicate可以看做是Function的一个特例，即Function代表的就是Predicate。

         */

        System.out.println("--------------------------------------------");
        List<Integer> integerList = Arrays.asList(1, 4, 2, 5, 2, 3, 9, 8);
        integerList.sort((a, b) -> a > b ? 1 : -1);
        System.out.println(integerList);

        System.out.println("--------------------------------------------");


    }
    @Test
    public void testSort(){
        List<Integer> integerList = Arrays.asList(1, 4, 2, 5, 2, 3, 9, 8);
        System.out.println(integerList);
        integerList.sort((a, b) -> a > b ? 1 : -1);
        System.out.println(integerList);
    }


    @Test
    public void testcase() {
        List<Integer> integerList = Arrays.asList(4, 1, 2, 5, 2, 3, 9, 8);
        System.out.println(integerList);
        integerList.sort((a, b) -> a > b ? 1 : -1);
        System.out.println(integerList);
        integerList.sort((a, b) -> b > a ? 1 : -1);
        System.out.println(integerList);
    }

    @Test
    public void test() {
        List<String> friends = Arrays.asList("lucy", "lily", "ted", "jim", "cele", "tom");
        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(name -> name.length())
                        .sum());

    }

    @Test
    public void test00(){

        System.out.println("18694558637".substring(7,11));
        String ss = "18694558637";
        System.out.println(ss.substring(ss.length()-4));
    }


}
