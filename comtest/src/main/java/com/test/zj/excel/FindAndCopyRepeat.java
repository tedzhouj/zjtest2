package com.test.zj.excel;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by zhoujun on 2017/9/4.
 */
public class FindAndCopyRepeat {
    public static void main(String[] args) {
        try {
            new FindAndCopyRepeat().copyPathForScript("D:\\MySchedule\\Now\\!!!!环境Excel-0629\\赞分期生产服务器0605.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void copyPathForScript(String filePath) throws Exception {
        Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        Sheet sheet = workbook.getSheet("业务");

        Row row;
        Cell cell;
        //项目名称 端口
        String lastIP = "";
        StringBuffer allServiceList = new StringBuffer();
        for (int i = 5; i <= 42; i++) {
            //for (int j=1;j<)
            row = sheet.getRow(i);
            cell = row.getCell(1);
            String serviceName = readRecordValue(cell);
            allServiceList.append(serviceName).append("\n");
            //   System.out.println("--------\n" + ss + "\n--------");

            cell = row.getCell(2);
            String port = readRecordValue(cell);


            cell = row.getCell(6);//外网ip
            String ipContent;
            ipContent = readRecordValue(cell);
            if (StringUtils.isEmpty(ipContent) || StringUtils.isBlank(ipContent)) {
                ipContent = lastIP;
            } else {
                lastIP = ipContent;
            }
            String[] ips = ipContent.split("\n");
            int finalI = i;
            Arrays.asList(ips).forEach(
                    record -> {
                        //   System.out.println("s:" + record);
                        printScript(serviceName, record, finalI);
                    }
            );
        }
        stringToFile( allServiceList.toString(),"服务列表" ,"txt");
    }

    public void testCopy2(String fileToBeRead) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
        HSSFSheet sheet = workbook.getSheet("sheet1");
        // 在Excel文档中，第一张工作表的缺省索引是0，
        // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
        //        HSSFRow row = sheet.getRow(0);
        //        HSSFCell cell = row.getCell((short) 0);
        HSSFRow row;
        HSSFCell cell;
        //i 行 j 列  第一行空
        for (int i = 1; i <= 3; i++) {
            //for (int j=1;j<)
            row = sheet.getRow(i);
            cell = row.getCell(2);
            String ss = readRecordValue(cell);
            System.out.println("--------\n" + ss + "\n--------");
            String[] ips = ss.split("\n");
            Arrays.asList(ips).forEach(
                    record -> {
                        System.out.println("s:" + record);
                    }
            );

        }
    }

//    public String readRecordValue(HSSFCell cell) {
//        String value = "";
//        if (cell != null) {
//            switch (cell.getCellTypeEnum()) {
//                case FORMULA:
//                    value = "" + cell.getCellFormula();
//                    break;
//                case NUMERIC:
//                    value = "" + cell.getNumericCellValue();
//                    break;
//                case STRING:
//                    value = cell.getStringCellValue();
//                    break;
//                case BLANK:
//                    value = " ";
//                    break;
//                case BOOLEAN:
//                    value = "" + cell.getBooleanCellValue();
//                    break;
//                case ERROR:
//                    value = "" + cell.getErrorCellValue();
//                    break;
//                default:
//                    value = "";//"UNKNOWN value of type " + cell.getCellTypeEnum();
//            }
//        }
//        return value;
//    }

    public String readRecordValue(Cell cell) {
        String value = "";
        if (cell != null) {
            switch (cell.getCellTypeEnum()) {
                case FORMULA:
                    value = "" + cell.getCellFormula();
                    break;
                case NUMERIC:
                    value = "" + cell.getNumericCellValue();
                    break;
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case BLANK:
                    value = " ";
                    break;
                case BOOLEAN:
                    value = "" + cell.getBooleanCellValue();
                    break;
                case ERROR:
                    value = "" + cell.getErrorCellValue();
                    break;
                default:
                    value = "";//"UNKNOWN value of type " + cell.getCellTypeEnum();
            }
        }
        return value;
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
        stringToFile(out, serviceName + "_" + i);
    }

    public void stringToFile(String content, String name) {
        stringToFile(content, name, "vbs");
    }

    public void stringToFile(String content, String name, String last) {
        File file = new File("D:\\MySchedule\\Now\\loginScript\\new\\" + name + "." + last);
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
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
