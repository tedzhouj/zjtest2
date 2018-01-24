package com.zj.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.List;
import java.util.Map;

/**
 * Created by zhoujun on 2017/11/4.
 */
@Slf4j
public class ExcelTools {


    /**
     * @param sheet      sheet
     * @param values     结果集
     * @param copyRow    复制样式的行
     * @param startRow   结果集开始插入行
     * @param margeCells 需要合并的单元格
     * @param totalValue 需要计算总值的列
     */
    public static void insertRowsString(XSSFSheet sheet, List<String[]> values,
                                        int copyRow, int startRow, Map<Integer, Integer> margeCells,
                                        String[] totalValue, int... place) {
        XSSFRow targetRow = sheet.getRow(copyRow);
        // 1传入的list大小确定添加的行数
        if (values == null || values.size() < 1) {
            return;
        }
        int n = values.size();
        // 插入行
        if (n > 1) {
            sheet.shiftRows(startRow, sheet.getLastRowNum(), n - 1, true, false);
        }
        // 插入值ֵ
        for (int i = 0; i < values.size(); i++) {

            String[] field = values.get(i);
            if (field == null || field.length < 1) {
                continue;
            }

            XSSFCell sourceCell;
            XSSFCell targetCell;
            // 开始的时候有一处空行
            XSSFRow row = sheet.createRow(startRow + i - 1);
            if (targetRow != null) {
                row.setHeight(targetRow.getHeight());
            }
            for (int m = 0; m < targetRow.getPhysicalNumberOfCells(); m++) {
                sourceCell = row.createCell(m);
                targetCell = targetRow.getCell(m);
                if (targetCell == null) {
                    targetCell = targetRow.createCell(m);
                }
                sourceCell.setCellStyle(targetCell.getCellStyle());
                sourceCell.setCellType(targetCell.getCellType());
            }
            for (int j = 0; j < field.length; j++) {
                if (null == field[j]) {
                    continue;
                }
                //判断值是否为空
                String str = field[j];
                XSSFCell cell = row.getCell(j);
                if (cell == null) {
                    cell = row.createCell(j);
                }
                XSSFRichTextString string = new XSSFRichTextString(str);
                cell.setCellValue(string);
            }
            // 合并单元格
            if (null != margeCells) {
                for (int key : margeCells.keySet()) {
                    CellRangeAddress cellRangeAddress = new CellRangeAddress(
                            startRow + i - 1, startRow + i - 1, key, margeCells.get(key));
                    sheet.addMergedRegion(cellRangeAddress);
                }
            }


            //设置总值
            if (null != totalValue) {
                int totalRowNum = startRow + values.size() - 1;
                XSSFRow totalRow = sheet.getRow(totalRowNum);
                int displace = 0;
                if (place != null) {
                    displace = place[0];
                }
                for (String totalString : totalValue) {
                    totalRow.getCell(displace++).setCellValue(new XSSFRichTextString(totalString));
                }
            }
        }
    }

    /***
     * 获取Sheet中的某一行
     *
     * @param sheet    2007以上Excel Sheet对象
     * @param rowIndex Excel中行数
     * @return 返回Excel行对象
     */
    public static XSSFRow getRow(XSSFSheet sheet, Integer rowIndex) {
        XSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        return row;
    }

    public static void setCellValue(XSSFRow row, int cellNo, String value) {
        setCellValue(row, cellNo, null, value);
    }

    public static void setCellValue(XSSFRow row, int cellNo, HSSFCellStyle style, String value) {
        XSSFCell cell = row.getCell(cellNo);
        if (cell == null) {
            cell = row.createCell(cellNo);
        }
        if (style != null) {
            cell.setCellStyle(style);
        }
        cell.setCellValue(value);
    }


}
