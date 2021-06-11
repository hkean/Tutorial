package com.github.tutorial.template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.tutorial.model.Demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

// https://www.vogella.com/tutorials/FreeMarker/article.html

public class TemplateMain {

	public static void main(String[] args) {

//		Configuration cfg = new TemplateConfiguration().getCfg();
		Configuration cfg = TemplateFactory.getTemplateConfiguration("TemplateConfiguration").getCfg();

		// 2. Proccess template(s)
		//
		// You will do this for several times in typical applications.

		// 2.1. Prepare the template input:

		Map<String, Object> input = new HashMap<String, Object>();

		input.put("title", "Vogella example");

		input.put("exampleObject", new Demo(1, "name", Boolean.TRUE));

		List<Demo> systems = new ArrayList<>();
		systems.add(new Demo(1, "Android", Boolean.TRUE));
		systems.add(new Demo(1, "iOS", Boolean.TRUE));
		systems.add(new Demo(1, "Ubuntu", Boolean.TRUE));
		systems.add(new Demo(1, "Win7", Boolean.TRUE));
		input.put("systems", systems);

		input.put("date", new Date());
		input.put("dateStr", "15/12/2020");
		
		Double d = 1120.10;
		Double dWOdecimal = 100.011;
		Double m = 1000000000.0;
		input.put("d", d);
		input.put("dWOdecimal", dWOdecimal);
		input.put("m", m);
		
		input.put("year", 2020);
		
		input.put("text", "12345678901");
		// 2.2. Get the template
		try (Writer fileWriter = new FileWriter(new File("output.txt"));) {

			Template template = cfg.getTemplate("template.txt");
			// 2.3. Generate the output

			// Write output to the console
			Writer consoleWriter = new OutputStreamWriter(System.out);
			template.process(input, consoleWriter);

			// For the sake of example, also write output into a file:

			template.process(input, fileWriter);

			// into byte?
			Writer strWriter = new StringWriter();
			template.process(input, strWriter);
			byte[] content = strWriter.toString().getBytes();

		} catch (IOException | TemplateException e) {
			e.printStackTrace();
		}
	}

}
