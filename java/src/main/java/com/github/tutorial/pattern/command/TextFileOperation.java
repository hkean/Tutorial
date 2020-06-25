package com.github.tutorial.pattern.command;

// 1. Command

@FunctionalInterface
public interface TextFileOperation {
	String execute();
}
