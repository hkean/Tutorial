package com.github.tutorial.template;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class TemplateConfiguration implements TemplateInterface {

	Configuration cfg;

	public TemplateConfiguration() {
		cfg = new Configuration(Configuration.VERSION_2_3_30);

		// Where do we load the templates from:
//		cfg.setClassForTemplateLoading(classz, "templates");
		try {
			cfg.setDirectoryForTemplateLoading(new File("." + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "templates"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Some other recommended settings:
//		cfg.setIncompatibleImprovements(new Version(2, 3, 30));
		cfg.setDefaultEncoding("UTF-8");
//		cfg.setLocale(Locale.getDefault());
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);
		cfg.setFallbackOnNullLoopVariable(false);
		
//		cfg.setNumberFormat("0.##");

	}

	public Configuration getCfg() {
		return this.cfg;
	}

}
