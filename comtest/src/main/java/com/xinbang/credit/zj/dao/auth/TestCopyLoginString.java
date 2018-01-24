package com.xinbang.credit.zj.dao.auth;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by zhoujun on 2017/9/3.
 */
public class TestCopyLoginString {


    public static void main(String[] args) {
        File file = new File("D:\\MySchedule\\Now\\!!!!环境Excel-0629\\赞分期生产服务器0605.xlsx");


    }


    public void printScript(String serviceName, String ip, int i) {
        String out =
                "Sub Main\n" +
                "    ' *** Send ***\n" +
                "    xsh.Screen.Send(\"ssh xblogread@" + ip + "\")\n" +
                "    xsh.Screen.Send(VbCr)\n" +
                "    ' *** WaitForString ***\n" +
                "    xsh.Screen.WaitForString(\"password:\")\n" +
                "    ' *** Send ***\n" +
                "    xsh.Screen.Send(\"XB@log981\")\n" +
                "    xsh.Screen.Send(VbCr)\n" +
                "    xsh.Screen.Send(\"cd /data/appLogs\")\n" +
                "    xsh.Screen.Send(VbCr)\n" +
                "End Sub";
        System.out.println(out);
        stringToFile(out, serviceName + i);
    }

    public void stringToFile(String content, String name) {
        File file = new File("D:\\MySchedule\\Now\\loginScript\\new\\" + name + ".vbs");
        if (file.exists()) {
            //todo
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //读
        //BufferedReader input = new BufferedReader(new FileReader(file));

        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void testPrint(String ip, String serviceName) {

        String strIp = ip;
        String out = "Sub Main\n" +
                "    ' *** Send ***\n" +
                "    xsh.Screen.Send(\"ssh xblogread@" + strIp + "\")\n" +
                "    xsh.Screen.Send(VbCr)\n" +
                "    ' *** WaitForString ***\n" +
                "    xsh.Screen.WaitForString(\"password:\")\n" +
                "    ' *** Send ***\n" +
                "    xsh.Screen.Send(\"XB@log981\")\n" +
                "    xsh.Screen.Send(VbCr)\n" +
                "End Sub";
        System.out.println(serviceName);
        System.out.println(out);
    }
}
