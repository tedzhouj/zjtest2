import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhoujun on 2017/7/6.
 */
public class BlockingQueueTest {

    /**BlockingQueue,如果BlockQueue是空的,从BlockingQueue取东西的操作将会被阻断进入等待状态,直到BlockingQueue进了东西才会被唤醒.
     * 同样,如果BlockingQueue是满的,任何试图往里存东西的操作也会被阻断进入等待状态,直到BlockingQueue里有空间才会被唤醒继续操作.
     * 1)add(anObject):把anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则报异常
     * 2)offer(anObject):表示如果可能的话,将anObject加到BlockingQueue里,即如果BlockingQueue可以容纳,则返回true,否则返回false.
     * 3)put(anObject):把anObject加到BlockingQueue里,如果BlockQueue没有空间,
     * 则调用此方法的线程被阻断直到BlockingQueue里面有空间再继续.
     * 4)poll(time):取走BlockingQueue里排在首位的对象,若不能立即取出,
     * 则可以等time参数规定的时间,取不到时返回null
     * 5)take():取走BlockingQueue里排在首位的对象,若BlockingQueue为空,
     * 阻断进入等待状态直到Blocking有新的对象被加入为止
     * 2.BlockingQueue有四个具体的实现类,根据不同需求,选择不同的实现类
     * 1)ArrayBlockingQueue:规定大小的BlockingQueue,其构造函数必须带一个int参数来指明其大小.
     * 其所含的对象是以FIFO(先入先出)顺序排序的.
     * 2)LinkedBlockingQueue:大小不定的BlockingQueue,若其构造函数带一个规定大小的参数,生成的BlockingQueue有大小限制,若不带大小参数,
     * 所生成的BlockingQueue的大小由Integer.MAX_VALUE来决定.
     * 其所含的对象是以FIFO(先入先出)顺序排序的
     * 3)PriorityBlockingQueue:类似于LinkedBlockQueue,但其所含对象的排序不是FIFO,而是依据对象的自然排序顺序或者是构造函数的Comparator决定的顺序.
     * 4)SynchronousQueue:特殊的BlockingQueue,对其的操作必须是放和取交替完成的.
     */

    public static void main(String[] args) {
        final ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        List<String> addList = new ArrayList<>();
        addList.add("001");
        addList.add("002");
        addList.add("003");
        addList.add("004");
        addList.add("005");
        addList.add("006");
        addList.add("007");
        addList.add("008");
        addList.add("009");
        addList.add("010");
        final int[] next = {0};
        int[] tt = {100};

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep((long) (Math.random() * 500));
                        System.out.println(Thread.currentThread().getName() + "准备放数据!");
                        if(next[0] <=9)
                        {queue.put(addList.get(next[0]));
                         next[0]++;
                        }else{
                            System.out.println("not add");
                        }

                        System.out.println(Thread.currentThread().getName() + "已经放了数据，" +
                                "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                try {
                    //将此处的睡眠时间分别改为100和1000，观察运行结果
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "准备取数据!");
                    String str = (String)queue.take();
                    System.out.println("-------------"+Thread.currentThread().getName()+"--------------output str:"+str);
                    System.out.println(Thread.currentThread().getName() + "已经取走数据，" +
                            "队列目前有" + queue.size() + "个数据");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
