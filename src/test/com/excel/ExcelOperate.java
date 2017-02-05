package test.com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperate {

	public static void createExcel() {
		String filePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "excel"
				+ File.separator + "扫描.xls";
		Workbook workbook = new HSSFWorkbook(); // 创建Excel文件(Workbook)
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setBold(true);//字体加粗
		font.setColor((short) 2);//改变字体颜色
		style.setFont(font);
		Sheet sheet = workbook.createSheet("sss");// 创建工作表(Sheet)
		sheet = workbook.createSheet("Test");// 创建工作表(Sheet)
		Row row = sheet.createRow(0);// 创建行,从0开始
		Cell cell = row.createCell(0);// 创建行的单元格,也是从0开始
		cell.setCellValue("aaaa");// 设置单元格内容
		cell.setCellStyle(style);
		CellStyle style1 = workbook.createCellStyle();
		style1.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//靠右对齐
		style1.setDataFormat(workbook.createDataFormat().getFormat("#,##0"));//千分位
		style1.setFont(font);
		row.createCell(1).setCellValue("aaaa");// 设置单元格内容,重载
		row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
		Cell cell2 = row.createCell(3);
		cell2.setCellStyle(style1);
		cell2.setCellValue(1234567);// 设置单元格内容,重载
		Row row2 = sheet.createRow(1);
		row2.createCell(3).setCellValue(123123);
		FileOutputStream out;
		try {
			out = new FileOutputStream(filePath);
			workbook.write(out);// 保存Excel文件
			out.close();// 关闭文件流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readExcel() throws EncryptedDocumentException, InvalidFormatException, IOException {
		String filePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "excel"
				+ File.separator + "扫描.xls";
		// poi读取excel
		// 创建要读入的文件的输入流
		InputStream inp = new FileInputStream(filePath);
		// 根据上述创建的输入流 创建工作簿对象
		Workbook workbook = WorkbookFactory.create(inp);
		Sheet sheet = workbook.createSheet("vvvvv");
		Row row = sheet.createRow(0);// 创建行,从0开始
		Cell cell = row.createCell(0);// 创建行的单元格,也是从0开始
		cell.setCellValue("aaaa");// 设置单元格内容
		row.createCell(1).setCellValue("aaaa");// 设置单元格内容,重载
		row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
		row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载
		FileOutputStream out;
		out = new FileOutputStream(filePath);
		workbook.write(out);// 保存Excel文件
		out.close();// 关闭文件流
		workbook.close();

	}

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		createExcel();
	}
}
