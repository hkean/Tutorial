package com.github.tutorial.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.github.tutorial.model.builder.Student;
import com.github.tutorial.model.builder.Widget;

public class ExcelMain {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		path += File.separator + "target" + File.separator;
		String fileName = "excel.xlsx";
		String sheetName = "";
		byte[] content = null;

		Student p1 = Student.builder().id(1L).name("1").build();
		Student p2 = Student.builder().id(2L).name("2").build();
		List<Student> students = Arrays.asList(p1, p2);
		sheetName = "students";
//		ExcelUtil.listContentExcel(Boolean.FALSE, 0, path + fileName, sheetName, students);
		content = ExcelUtil.multipleGenericByte(content, sheetName, students);

		Widget w1 = Widget.hiddenBuilder().name("w1").build();
		Widget w2 = Widget.hiddenBuilder().name("w2").build();
		List<Widget> widgets = Arrays.asList(w1, w2);
		sheetName = "widgets";
//		ExcelUtil.listContentExcel(Boolean.FALSE, 1, path + fileName, sheetName, widgets);
		content = ExcelUtil.multipleGenericByte(content, sheetName, widgets);

//		ExcelUtil.readExcel(path + fileName);

		try (FileOutputStream stream = new FileOutputStream(path + fileName)) {
			stream.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
