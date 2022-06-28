package thehv.shares;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class SheetUtil {
    public static void setCellFormula(XSSFSheet sheet, int rowIndex, int colIndex, String formula) {
        rowIndex--;
        colIndex--;
        XSSFRow row = sheet.getRow(rowIndex);
        row = row != null ? row : sheet.createRow(rowIndex);
        XSSFCell cell = row.getCell(colIndex);
        cell = cell != null ? cell : row.createCell(colIndex);
        cell.setCellFormula(formula);
    }

    public static void setCell(XSSFSheet sheet, int rowIndex, int colIndex, Object value, Class<?> clazz) {
        rowIndex--;
        colIndex--;
        XSSFRow row = sheet.getRow(rowIndex);
        row = row != null ? row : sheet.createRow(rowIndex);
        XSSFCell cell = row.getCell(colIndex);
        cell = cell != null ? cell : row.createCell(colIndex);

        if (clazz == Long.class) {
            Long valueLong = value != null ? Long.parseLong(value.toString()) : 0L;
            cell.setCellType(CellType.NUMERIC);
            cell.setCellValue(valueLong);
        } else {
            String cellValue = String.valueOf(cell);
            String valueString = value != null ? value.toString() : null;
            cell.setCellType(CellType.STRING);
            cell.setCellValue(cellValue != null ? cellValue + valueString : valueString);
        }
    }

    public static String getColName(int columnNumber) {
        int dividend = columnNumber;
        String columnName = "";
        int modulo;
        while (dividend > 0) {
            modulo = (dividend - 1) % 26;
            columnName = (char) (65 + modulo) + columnName;
            dividend = (int) ((dividend - modulo) / 26);
        }
        return columnName;
    }
}