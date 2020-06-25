package com.github.tutorial.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.events.XMLEvent;

public class ReplaceTextXml {
	// maybe switch to array for more text to replace
	String replaceFrom = "bmi";
	String replaceTo = "";
	String fileExtension = "xml";

	File tmpFile = new File("tmp");

	public static void main(String[] args) {
		new ReplaceTextXml();
	}

	ReplaceTextXml() {
		// get all files
		List<File> files = listf(this.getClass().getClassLoader().getResource(".").getPath(), new ArrayList<File>());

		// for each file, run the logic
		files.forEach(f -> readFile(f));

		// delete tmp file once finish run
		try {
			Files.deleteIfExists(Paths.get("tmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// read xml and etc
	private void readFile(File f) {
		System.out.println("running this file: " + f.getName());
		
		try (FileInputStream fis = new FileInputStream(f); FileOutputStream fos = new FileOutputStream(tmpFile);) {
			XMLEventReader eventReader = XMLInputFactory.newInstance().createXMLEventReader(fis);
			XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(fos);
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				if (event.getEventType() == XMLEvent.START_ELEMENT
						&& event.asStartElement().getName().toString().equals(replaceFrom)) {
					// write Person startElement:
					writer.add(event);

					// get the replace text
					XMLEvent tmpEvent = eventReader.nextEvent();
					// then replace
					Object result = replaceCore(tmpEvent);

					// write into output
					if (null != result) {
						writer.add(eventFactory.createCharacters(result.toString()));
					} else {
						System.out.println("filename: " + f.getName());
						System.out.println("value that cause error: " + tmpEvent);
						writer.add(tmpEvent);
					}
				} else {
					writer.add(event);
				}
			}

			writer.close();

			// copy over
			overwrite(f);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------------------------------------");
		}
	}

	// logic for replacement
	private Object replaceCore(XMLEvent xmlEvent) {
		try {
			Double tmp = Double.parseDouble(xmlEvent.asCharacters().toString());

			while (3.0 <= tmp) {
				tmp /= 10;
			}

			return tmp;
		} catch (Exception e) {
			System.out.println("err message: " + e.getMessage());
			return null;
		}
	}

	// overwrite if needed, or just write into a new file
	private void overwrite(File f) {
		try (FileInputStream fis = new FileInputStream(tmpFile); FileOutputStream fos = new FileOutputStream(f);) {

			XMLEventReader outputReader = XMLInputFactory.newInstance().createXMLEventReader(fis);
			XMLEventWriter output = XMLOutputFactory.newInstance().createXMLEventWriter(fos);
			output.add(outputReader);

			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// read all sub-directories as well
	private List<File> listf(String directoryName, List<File> files) {
		File directory = new File(directoryName);

		// Get all files from a directory.
		File[] fList = directory.listFiles();
		if (fList != null) {
			for (File file : fList) {
				if (file.isFile() && file.getName().endsWith(fileExtension)) {
					files.add(file);
				} else if (file.isDirectory()) {
					listf(file.getAbsolutePath(), files);
				}
			}
		}

		return files;
	}
}
