package com.github.tutorial.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public <T> void writeExcel(String fileName, String sheetName, List<T> data) {
		File file = null;
		OutputStream fos = null;
		Workbook workbook = null;
		Sheet sheet = null;

		try {
			file = new File(fileName);
			if (file.exists()) {
				workbook = WorkbookFactory.create(new FileInputStream(file));
			} else {
				workbook = new XSSFWorkbook();
			}

			// init
			Class<? extends Object> classz = data.get(0).getClass();
			List<String> fieldNames = getFieldNamesForClass(classz);
			int rowCount = 0;
			int columnCount = 0;
			sheet = workbook.createSheet(sheetName);

			// create a header row
			Row row = sheet.createRow(rowCount++);
			for (int i = 0; i < fieldNames.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(fieldNames.get(i));
			}

			// create data row
			for (T t : data) {
				row = sheet.createRow(rowCount++);
				columnCount = 0;
				for (String fieldName : fieldNames) {
					Cell cell = row.createCell(columnCount);
					Method method = null;
					try {
						method = classz.getMethod("get" + camelCase(fieldName));
					} catch (NoSuchMethodException nme) {
						method = classz.getMethod("get" + fieldName);
					}
					Object value = method.invoke(t, (Object[]) null);
					if (value != null) {
						if (value instanceof String) {
							cell.setCellValue((String) value);
						} else if (value instanceof Long) {
							cell.setCellValue((Long) value);
						} else if (value instanceof Integer) {
							cell.setCellValue((Integer) value);
						} else if (value instanceof Double) {
							cell.setCellValue((Double) value);
						}
					}
					columnCount++;
				}
			}

			// write into a file
			fos = new FileOutputStream(file);
			workbook.write(fos);
			fos.flush();
		} catch (IOException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
			}
			try {
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
			}
		}
	}

	public void readExcel(String fileName) {
		File file = null;
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			file = new File(fileName);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);

			// run through all the sheets
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
				Iterator<Row> itr = sheet.iterator();
				while (itr.hasNext()) {
					Row row = itr.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case STRING: // field that represents string cell type
							System.out.print(cell.getStringCellValue() + "\t\t\t");
							break;
						case NUMERIC: // field that represents number cell type
							if (DateUtil.isCellDateFormatted(cell)) {
								System.out.print(cell.getDateCellValue() + "\t\t\t");
							} else {
								System.out.print(cell.getNumericCellValue() + "\t\t\t");
							}
							break;
						case FORMULA: // field that represents formula cell type
							System.out.print(cell.getCellFormula() + "\t\t\t");
							break;
						case BOOLEAN: // field that represents boolean cell type
							System.out.print(cell.getBooleanCellValue() + "\t\t\t");
							break;
						case ERROR: // field that represents error cell type
							System.out.print(cell.getErrorCellValue() + "\t\t\t");
							break;
						default:
						}
					}
					System.out.println("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
			}
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {
			}
		}
	}

	// retrieve field names from a POJO class
	private List<String> getFieldNamesForClass(Class<?> clazz) {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fieldNames.add(fields[i].getName());
		}
		return fieldNames;
	}

	// capitalize the first letter of the field name
	// for retriving value of the field later
	private String camelCase(String s) {
		if (s.length() == 0)
			return s;
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
