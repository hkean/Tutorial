package com.github.tutorial.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
	
	public static void createFolder(String baseFolder, String yearMonthDay) {
		Path path = Paths.get(baseFolder + yearMonthDay);
		// if directory exists?
		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
	}
	
}
