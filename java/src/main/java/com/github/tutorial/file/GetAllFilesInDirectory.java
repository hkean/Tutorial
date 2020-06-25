/*****************************************************************/
/* Copyright 2013 Code Strategies                                */
/* This code may be freely used and distributed in any project.  */
/* However, please do not remove this credit if you publish this */
/* code in paper or electronic form, such as on a web site.      */
/*****************************************************************/
package com.github.tutorial.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class GetAllFilesInDirectory {

	public static void main(String[] args) throws IOException {

		File dir = new File("D:\\HK\\phd\\dataset\\ReplicationPackage\\Systems\\JEdit\\jEdit\\");

		// read all in one time
//		System.out.println("Getting all files in " + dir.getCanonicalPath() + " including those in subdirectories");
		List<File> listFiles = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : listFiles) {
			System.out.println("file: " + file.getCanonicalPath());
		}

		// recursive read directory
		displayDirectoryContents(dir);

		// java library
		File[] files = dir.listFiles(new FileFilter() {
			public boolean accept(File f) {
				return f.getName().endsWith("txt");
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}

		// recursive read directory
		listf(".", new ArrayList<File>());
	}

	private static void displayDirectoryContents(File dir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("directory:" + file.getCanonicalPath());
					displayDirectoryContents(file);
				} else {
					System.out.println("     file:" + file.getCanonicalPath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<File> listf(String directoryName, List<File> files) {
		File directory = new File(directoryName);

		// Get all files from a directory.
		File[] fList = directory.listFiles();
		if (fList != null) {
			for (File file : fList) {
				if (file.isFile()) {
					files.add(file);
				} else if (file.isDirectory()) {
					listf(file.getAbsolutePath(), files);
				}
			}
		}

		return files;
	}
}
