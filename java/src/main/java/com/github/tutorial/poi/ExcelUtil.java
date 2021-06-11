package com.github.tutorial.poi;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	/**
	 * 
	 * @param <T>         generic class
	 * @param isOverwrite to determine overwrite or re-use an existing file
	 * @param sheetCount  if sheetCount > 0, then re-use existing file
	 * @param fileName    name of the output file
	 * @param sheetName   name for each sheet
	 * @param data        content of the excel data
	 */
	public static <T> void listContentExcel(Boolean isOverwrite, Integer sheetCount, String fileName, String sheetName,
			List<T> data) {
		if (!data.isEmpty()) {

			File file = null;
			OutputStream fos = null;
			Workbook workbook = null;
			Sheet sheet = null;

			try {
				file = new File(fileName);
				if ((file.exists() && !isOverwrite) || sheetCount > 0) {
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
							} else {
								cell.setCellValue(value.toString());
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
	}

	/**
	 * @param fileName name of the file
	 * @param data     map of sheet name in String and content in List object
	 */
	public static <T> void mapContentExcel(String fileName, Map<String, List<T>> data) {
		File file = null;
		OutputStream fos = null;
		Workbook workbook = null;
		Sheet sheet = null;

		try {
			file = new File(fileName);
			workbook = new XSSFWorkbook();

			Iterator<Map.Entry<String, List<T>>> iterator = data.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, List<T>> entry = iterator.next();

				if (!entry.getValue().isEmpty()) {
					// init
					Class<? extends Object> classz = entry.getValue().get(0).getClass();
					List<String> fieldNames = getFieldNamesForClass(classz);
					int rowCount = 0;
					int columnCount = 0;
					sheet = workbook.createSheet(entry.getKey());

					// create a header row
					Row row = sheet.createRow(rowCount++);
					for (int i = 0; i < fieldNames.size(); i++) {
						Cell cell = row.createCell(i);
						cell.setCellValue(fieldNames.get(i));
					}

					// create data row
					for (T t : entry.getValue()) {
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
								} else {
									cell.setCellValue(value.toString());
								}
							}
							columnCount++;
						}
					}
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

	public static <T> byte[] multipleGenericByte(byte[] content, String sheetName, List<T> data) {
		Workbook workbook = null;
		Sheet sheet = null;
		ByteArrayOutputStream bos = null;

		try {
			if (content == null) {
				workbook = new XSSFWorkbook();
			} else {
				InputStream is = new ByteArrayInputStream(content);
				workbook = WorkbookFactory.create(is);
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
						} else {
							cell.setCellValue(value.toString());
						}
					}
					columnCount++;
				}
			}

			bos = new ByteArrayOutputStream();
			workbook.write(bos);
		} catch (IOException | EncryptedDocumentException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
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

		return bos.toByteArray();
	}

//	public static void readExcel(String fileName) {
//		File file = null;
//		FileInputStream fis = null;
//		Workbook wb = null;
//		try {
//			file = new File(fileName);
//			fis = new FileInputStream(file);
//			wb = new XSSFWorkbook(fis);
//
//			// run through all the sheets
//			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
//				Sheet sheet = wb.getSheetAt(i);
//				Iterator<Row> itr = sheet.iterator();
//				while (itr.hasNext()) {
//					Row row = itr.next();
//					Iterator<Cell> cellIterator = row.cellIterator();
//					while (cellIterator.hasNext()) {
//						Cell cell = cellIterator.next();
//						switch (cell.getCellType()) {
//						case STRING: // field that represents string cell type
//							System.out.print(cell.getStringCellValue() + "\t\t\t");
//							break;
//						case NUMERIC: // field that represents number cell type
//							if (DateUtil.isCellDateFormatted(cell)) {
//								System.out.print(cell.getDateCellValue() + "\t\t\t");
//							} else {
//								System.out.print(cell.getNumericCellValue() + "\t\t\t");
//							}
//							break;
//						case FORMULA: // field that represents formula cell type
//							System.out.print(cell.getCellFormula() + "\t\t\t");
//							break;
//						case BOOLEAN: // field that represents boolean cell type
//							System.out.print(cell.getBooleanCellValue() + "\t\t\t");
//							break;
//						case ERROR: // field that represents error cell type
//							System.out.print(cell.getErrorCellValue() + "\t\t\t");
//							break;
//						default:
//						}
//					}
//					System.out.println("");
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fis != null) {
//					fis.close();
//				}
//			} catch (IOException e) {
//			}
//			try {
//				if (wb != null) {
//					wb.close();
//				}
//			} catch (IOException e) {
//			}
//		}
//	}

	// retrieve field names from a POJO class
	private static List<String> getFieldNamesForClass(Class<?> clazz) {
		List<String> fieldNames = new ArrayList<String>();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].getName().equalsIgnoreCase("serialVersionUID")) {
				fieldNames.add(fields[i].getName());
			}
		}
		return fieldNames;
	}

	// capitalize the first letter of the field name
	// for retrieving value of the field later
	private static String camelCase(String s) {
		if (s.length() == 0) {
			return s;
		}

		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
