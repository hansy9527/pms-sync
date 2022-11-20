package com.houli.pms.sync.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Component
public class ExcelExportUtil {
    /**
     *
     * @param fileName 文件名称
     * @param sheetName 工作簿名称
     * @param title 标题
     * @param heads 表头数据
     * @param data 数据
     * @param conditions 查询条件
     * @return
     */
    public static void export(String fileName, String sheetName, String title, String [] heads, List<List<String>> data,String conditions, HttpServletResponse response){
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建sheet
        HSSFSheet sheet =workbook.createSheet(sheetName);
        //设置默认宽度
        sheet.setDefaultColumnWidth(200*20);
        //标题行
        HSSFRow row = sheet.createRow(0);
        //设置标题高度
        row.setHeight((short) (200*5));
        //创建标题格
        HSSFCell cell = row.createCell(0);
        //标题样式
        HSSFCellStyle style = titleStyle(workbook);
        cell.setCellStyle(style);
        cell.setCellValue(title);
        //合并单元格，设置边框
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,heads.length-1);
        RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, cellRangeAddress, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeAddress, sheet);
        sheet.addMergedRegion(cellRangeAddress);

        //表头行
        HSSFRow rowHead = sheet.createRow(1);
        //表头样式
        HSSFCellStyle headStyle = headStyle(workbook);
        for (int i = 0; i < heads.length; i++) {
            HSSFCell cellHead = rowHead.createCell(i);
            cellHead.setCellValue(heads[i]);
            cellHead.setCellStyle(headStyle);
            sheet.setColumnWidth(i,200*35);
        }
        //数据填充
        //数据样式
        HSSFCellStyle dataStyle = dataStyle(workbook);
        for (int i = 0; i < data.size(); i++) {
            List<String> rowData =data.get(i);
            HSSFRow dataRow = sheet.createRow(i+2);
            for (int j = 0; j < rowData.size(); j++) {
                HSSFCell cellData = dataRow.createCell(j);
                cellData.setCellValue(rowData.get(j));
                cellData.setCellStyle(dataStyle);
            }
        }
        if(!ObjectUtils.isEmpty(conditions)){
            HSSFCellStyle conditionStyle = conditionStyle(workbook);
            HSSFRow conditionsRow = sheet.createRow(data.size()+2+5);
            HSSFCell cellData = conditionsRow.createCell(0);
            cellData.setCellValue("查询条件："+conditions);

            CellRangeAddress cellRangeAddressConditions = new CellRangeAddress(data.size()+2+5,data.size()+2+5,0,heads.length-1);
            RegionUtil.setBorderTop(BorderStyle.THIN, cellRangeAddressConditions, sheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, cellRangeAddressConditions, sheet);
            RegionUtil.setBorderLeft(BorderStyle.THIN, cellRangeAddressConditions, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, cellRangeAddressConditions, sheet);
            sheet.addMergedRegion(cellRangeAddressConditions);
            cellData.setCellStyle(conditionStyle);
        }
        try {
            setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            workbook.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 发送响应流方法
     */
    public static void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
//            try {
//                fileName = new String(fileName.getBytes(), "UTF-8");
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
            response.setContentType("application/octet-stream;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static HSSFCellStyle titleStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 24);
        font.setFontName("微软雅黑");
        style.setFont(font);
        return style;
    }
    public static HSSFCellStyle headStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 12);
        font.setFontName("微软雅黑");
        style.setFont(font);
        return style;
    }
    public static HSSFCellStyle dataStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("@"));
        return style;
    }
    public static HSSFCellStyle conditionStyle(HSSFWorkbook workbook){
        HSSFCellStyle style = workbook.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN); //下边框
        style.setBorderLeft(BorderStyle.THIN);//左边框
        style.setBorderTop(BorderStyle.THIN);//上边框
        style.setBorderRight(BorderStyle.THIN);//右边框
        style.setAlignment(HorizontalAlignment.LEFT);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        HSSFDataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("@"));
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        return style;
    }
}
