package thehv.shares;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExcelService {

	public byte[] export() throws Exception {
		try (XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("/var/otp/temp.xlsx"))) {
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(1);
			row = row != null ? row : sheet.createRow(1);
			XSSFCell cell = row.getCell(1);
			cell = cell != null ? cell : row.createCell(1);
			cell.setCellFormula("SUM(A1, A5)");
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			workbook.write(baos);
			byte[] xlsx = baos.toByteArray();
			workbook.close();
			return xlsx;
		}
	}
}