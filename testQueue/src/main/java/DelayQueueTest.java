//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.ArrayBlockingQueue;
//import java.util.concurrent.DelayQueue;
//
///**
// * Created by zhoujun on 2017/7/6.
// */
//public class DelayQueueTest {
//
//
//    public static void main(String[] args) {
//        final DelayQueue queue = new DelayQueue();
//        List<String> addList = new ArrayList<>();
//        addList.add("001");
//        addList.add("002");
//        addList.add("003");
//        addList.add("004");
//        addList.add("005");
//        addList.add("006");
//        addList.add("007");
//        addList.add("008");
//        addList.add("009");
//        addList.add("010");
//        final int[] next = {0};
//        int[] tt = {100};
//
//        for (int i = 0; i < 2; i++) {
//            new Thread(() -> {
//                while (true) {
//                    try {
//                        Thread.sleep((long) (Math.random() * 500));
//                        System.out.println(Thread.currentThread().getName() + "准备放数据!");
//                        if(next[0] <=9)
//                        {queue.put(addList.get(next[0]));
//                            next[0]++;
//                        }else{
//                            System.out.println("not add!");
//                        }
//
//                        System.out.println(Thread.currentThread().getName() + "已经放了数据，" +
//                                "队列目前有" + queue.size() + "个数据");
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }).start();
//        }
//
//
//        new Thread(() -> {
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            while (true) {
//                try {
//                    //将此处的睡眠时间分别改为100和1000，观察运行结果
//                    Thread.sleep(1000);
//                    System.out.println(Thread.currentThread().getName() + "准备取数据!");
//                    String str = (String)queue.take();
//                    System.out.println("-------------"+Thread.currentThread().getName()+"--------------output str:"+str);
//                    System.out.println(Thread.currentThread().getName() + "已经取走数据，" +
//                            "队列目前有" + queue.size() + "个数据.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//
//}
