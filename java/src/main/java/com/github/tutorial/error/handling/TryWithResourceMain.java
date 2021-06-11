package com.github.tutorial.error.handling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.baeldung.com/java-try-with-resources

public class TryWithResourceMain {

	private void tryWithResource() {
		try (Scanner scanner = new Scanner(new File("test.txt"))) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}

	private void tryWithMultipleResource() {
		try (Scanner scanner = new Scanner(new File("testRead.txt"));
				PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
			while (scanner.hasNext()) {
				writer.print(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// custom?

	private void tryWithResourceAndFinally() {
		try (Scanner scanner = new Scanner(new File("test.txt"))) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} finally {
			System.out.println("still work like a charm");
		}
	}
	
	// java 9??

}
