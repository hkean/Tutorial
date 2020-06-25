package com.github.tutorial.pattern.command;

// https://www.baeldung.com/java-command-pattern
// 4. Client

public class CommandMain {

	public static void main(String[] args) {
		TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
		textFileOperationExecutor.executeOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
		textFileOperationExecutor.executeOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
	}

	void lambda() {
		TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
		textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt");
		textFileOperationExecutor.executeOperation(() -> "Saving file file1.txt");
	}

	void method() {
		TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
		TextFile textFile = new TextFile("file1.txt");
		textFileOperationExecutor.executeOperation(textFile::open);
		textFileOperationExecutor.executeOperation(textFile::save);
	}
}
