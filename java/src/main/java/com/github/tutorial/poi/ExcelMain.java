package com.github.tutorial.poi;

import java.util.Arrays;
import java.util.List;

import com.github.tutorial.model.builder.Student;
import com.github.tutorial.model.builder.Widget;

public class ExcelMain {
	public static void main(String[] args) {
		String fileName = "excel.xlsx";
		String sheetName = "";
		ExcelUtil util = new ExcelUtil();

		Student p1 = Student.builder().id(1L).name("1").build();
		Student p2 = Student.builder().id(2L).name("2").build();
		List<Student> students = Arrays.asList(p1, p2);
		sheetName = "students";
		util.writeExcel(fileName, sheetName, students);

		Widget w1 = Widget.hiddenBuilder().name("w1").build();
		Widget w2 = Widget.hiddenBuilder().name("w2").build();
		List<Widget> widgets = Arrays.asList(w1, w2);
		sheetName = "widgets";
		util.writeExcel(fileName, sheetName, widgets);
		
		util.readExcel(fileName);
	}
}
