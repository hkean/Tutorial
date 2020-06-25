package com.github.tutorial.pattern.command;

// 1. Command

public class OpenTextFileOperation implements TextFileOperation {

	private TextFile textFile;

	OpenTextFileOperation(TextFile textFile) {
		this.textFile = textFile;
	}

	@Override
	public String execute() {
		return textFile.open();
	}
}
