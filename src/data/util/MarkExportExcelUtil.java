/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.util;

import data.dao.MarkDAOImpl;
import data.model.Mark;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author PhamMinhHoang
 */
public class MarkExportExcelUtil {

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public static void exportToExcelFile(String filePath, List<Mark> marks) throws IOException, SQLException, ClassNotFoundException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Bảng điểm sinh viên");
        
        int rownum = 0;
        Cell cell = null;
        Row row = sheet.createRow(rownum);;
        HSSFCellStyle style = createStyleForTitle(workbook);
        createHeaderOfTable(cell, row, style);
        // Data
        initData(marks, row, cell, sheet, rownum);
        File file = new File(filePath);

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        outFile.close();
        System.out.println("Created file: " + file.getAbsolutePath());
    }

    private static void createHeaderOfTable(Cell cell, Row row, HSSFCellStyle style) {
        String[] headers = new String[]{
            "STT", "Họ tên", "Mã sinh viên",
            "Chuyên cần", "Thực hành", "Bài tập",
            "Kiểm tra", "Thi", "Tổng kết",
            "Tổng kết bằng chữ", "Kết quả"
        };
        for (int i = 0; i < headers.length; i++) {
            cell = row.createCell(i, CellType.NUMERIC);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
    }

    private static void initData(List<Mark> marks, Row row, Cell cell, HSSFSheet sheet, int rownum) {
        for (Mark mark : marks) {
            rownum++;
            row = sheet.createRow(rownum);
            // STT (A)
            cell = row.createCell(0, CellType.NUMERIC);
            cell.setCellValue(rownum);
            // Họ tên (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(mark.getStudentName());
            // Mã sinh viên (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(mark.getStudentId());
            // Chuyên cần (D)
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(mark.getAttendance());
            // Thực hành (E)
            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(mark.getPracticse());
            // Bài tập (F)
            cell = row.createCell(5, CellType.NUMERIC);
            cell.setCellValue(mark.getProject());
            // Thi (G)
            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue(mark.getExamination());
            // Tổng kết (H)
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(mark.getFinalExamination());
            // Tổng kết bằng chữ (I)
            cell = row.createCell(8, CellType.NUMERIC);
            cell.setCellValue(mark.getFinalGrades());
            // EmpName (G)
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(mark.getFinalGradesInChar());
            // Kết quả (K)
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue(mark.getSummarize());
        }
    }
}
