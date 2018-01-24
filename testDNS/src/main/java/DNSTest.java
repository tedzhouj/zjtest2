import java.net.InetAddress;

/**
 * Created by zhoujun on 2017/7/8.
 */
public class DNSTest {
    public static void main(String[] args) throws Exception {
        InetAddress intetAddress = InetAddress.getByName("DESKTOP-39PE62O");//my dell pc name
        System.out.println(intetAddress);
        System.out.println("-----------------------------------");
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        System.out.println("-----------------------------------");

        InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");
        System.out.println(addresses.length);

        for (InetAddress addr : addresses) {
            System.out.println(addr);
        }


    }
}
