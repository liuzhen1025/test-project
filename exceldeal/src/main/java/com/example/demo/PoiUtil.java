/**
 * copyRight
 */
package com.example.demo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liuzhen
 * Created by liuzhen.
 * Date: 2018/11/27
 * Time: 11:11
 */
public class PoiUtil {
    private PoiUtil() {
    }
    /**
     * Excel2003和Excel2007+创建方式不同
     * Excel2003使用HSSFWorkbook 后缀xls
     * Excel2007+使用XSSFWorkbook 后缀xlsx
     * 此方法可保证动态创建Workbook
     *
     * @param is
     * @return
     */
    public static Workbook createWorkbook(InputStream is) throws IOException, InvalidFormatException {
        return WorkbookFactory.create(is);
    }

    /**
     *导入数据获取数据列表
     * @param wb
     * @return
     */
    public static List<List<Object>> getDataList(Workbook wb) {
        List<List<Object>> rowList = new ArrayList<>();
        for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = wb.getSheetAt(sheetNum);
            for (int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (null == row){
                    continue;
                }
                List<Object> cellList = new ArrayList<>();
                for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    cellList.add(getCellValue(cell));
                }
                rowList.add(cellList);
            }
        }
        return rowList;
    }

    private static String getCellValue(Cell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case NUMERIC: {
                    short format = cell.getCellStyle().getDataFormat();
                    if (format == 14 || format == 31 || format == 57 || format == 58) {   //excel中的时间格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil.getJavaDate(value);
                        cellvalue = sdf.format(date);
                    }
                    // 判断当前的cell是否为Date
                    else if (HSSFDateUtil.isCellDateFormatted(cell)) {  //先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                        // 如果是Date类型则，取得该Cell的Date值           // 对2014-02-02格式识别不出是日期格式
                        Date date = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = formater.format(date);
                    } else { // 如果是纯数字
                        // 取得当前Cell的数值
                        cellvalue = NumberToTextConverter.toText(cell.getNumericCellValue());

                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getStringCellValue().replaceAll("'", "''");
                    break;
                case BLANK:
                    cellvalue = null;
                    break;
                // 默认的Cell值
                default: {
                    cellvalue = " ";
                }
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * 此方法生成表头并写入表头名称
     *
     * @param nodes 节点
     * @param sheet 工作簿
     * @param style 单元格样式
     * @return 数据加载开始行
     */
    public static int generateHeader(List<HeaderNode> nodes, Sheet sheet, CellStyle style) {
        Map<RowKey, Row> hssfRowMap = new HashMap<>();
        int dataStartRow = 0;
        for (HeaderNode node : nodes) {
            if (!(node.firstRow == node.getLastCol())) {
                CellRangeAddress cra = new CellRangeAddress(node.getFirstRow(), node.getLastRow(),
                        node.getFirstCol(), node.getLastCol());
                sheet.addMergedRegion(cra);
            }
            dataStartRow = dataStartRow >= node.getLastRow() ? dataStartRow : node.getLastRow();
            RowKey key = new RowKey();
            key.setFirstRow(node.getFirstRow());
            key.setLastRow(node.getLastRow());
            Row row = hssfRowMap.get(key);
            if (null == row) {
                row = sheet.createRow(node.getFirstRow());
                hssfRowMap.put(key, row);
            }
            Cell cell = row.createCell(node.getFirstCol());
            cell.setCellValue(node.getName());

            cell.setCellStyle(style);
        }
        /*for (int i =0; i<dataStartRow; i++) {
            Row row = sheet.getRow(i);
            for (HeaderNode node : nodes) {

            }
        }*/
        return dataStartRow+1;
    }

    public static class HeaderNode {
        private String name;
        private int firstRow;
        private int lastRow;
        private int firstCol;
        private int lastCol;
        //水平LEFT,
        //CENTER,
        //RIGHT,
        private String horizontalAlignment;
        //垂直TOP,
        //CENTER,
        //BOTTOM,
        private String verticalAlignment;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getFirstRow() {
            return firstRow;
        }

        public void setFirstRow(int firstRow) {
            this.firstRow = firstRow;
        }

        public int getLastRow() {
            return lastRow;
        }

        public void setLastRow(int lastRow) {
            this.lastRow = lastRow;
        }

        public int getFirstCol() {
            return firstCol;
        }

        public void setFirstCol(int firstCol) {
            this.firstCol = firstCol;
        }

        public int getLastCol() {
            return lastCol;
        }

        public void setLastCol(int lastCol) {
            this.lastCol = lastCol;
        }

        public String getHorizontalAlignment() {

            return horizontalAlignment;
        }

        public void setHorizontalAlignment(String horizontalAlignment) {

            this.horizontalAlignment = horizontalAlignment;
        }

        public String getVerticalAlignment() {

            return verticalAlignment;
        }

        public void setVerticalAlignment(String verticalAlignment) {

            this.verticalAlignment = verticalAlignment;
        }
    }

    private static class RowKey {
        private int firstRow;
        private int lastRow;

        public int getFirstRow() {
            return firstRow;
        }

        public void setFirstRow(int firstRow) {
            this.firstRow = firstRow;
        }

        public int getLastRow() {
            return lastRow;
        }

        public void setLastRow(int lastRow) {
            this.lastRow = lastRow;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof RowKey)) {
                return false;
            }
            RowKey key = (RowKey) o;
            return firstRow == key.firstRow &&
                    lastRow == key.lastRow;
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstRow, lastRow);
        }
    }

    public static void main(String[] args) {
        // 第一步，创建一个webbook，对应一个Excel文件
        Workbook workbook = new XSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        Sheet sheet = workbook.createSheet("测试");
        // 第四步，创建单元格，并设置值表头 设置表头居中
        CellStyle style = workbook.createCellStyle();
        // 水平居中格式LEFT,
        //CENTER,
         //       RIGHT,
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中TOP,
        //CENTER,
         //       BOTTOM,
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        List<HeaderNode> nodes = new ArrayList<>();
        HeaderNode headerNode1 = new HeaderNode();
        headerNode1.setName("标题");
        headerNode1.setFirstRow(0);
        headerNode1.setLastRow(1);
        headerNode1.setFirstCol(0);
        headerNode1.setLastCol(8);
        nodes.add(headerNode1);
        HeaderNode headerNode34 = new HeaderNode();
        headerNode34.setName("建设项目名称");
        headerNode34.setFirstRow(2);
        headerNode34.setLastRow(2);
        headerNode34.setFirstCol(0);
        headerNode34.setLastCol(8);
        nodes.add(headerNode34);
        HeaderNode headerNode2 = new HeaderNode();
        headerNode2.setName("    ");
        headerNode2.setFirstRow(3);
        headerNode2.setLastRow(4);
        headerNode2.setFirstCol(0);
        headerNode2.setLastCol(0);
        nodes.add(headerNode2);
        HeaderNode headerNode3 = new HeaderNode();
        headerNode3.setName("招标范围");
        headerNode3.setFirstRow(3);
        headerNode3.setLastRow(3);
        headerNode3.setFirstCol(1);
        headerNode3.setLastCol(2);
        nodes.add(headerNode3);
        generateHeader(nodes, sheet, style);
        try {
            FileOutputStream output = new FileOutputStream("d:\\workbook.csv");
            workbook.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
