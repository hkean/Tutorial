package com.github.tutorial.template;

public class TemplateFactory {
	public static TemplateInterface getTemplateConfiguration(String criteria) {
		if (criteria.equals("TemplateConfiguration")) {
			return new TemplateConfiguration();
		}

		return null;
	}
}
