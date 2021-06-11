package com.github.tutorial.csv;

import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import com.github.tutorial.model.CyberSource;
import com.github.tutorial.model.Demo;
import com.google.common.collect.Iterables;

// https://www.baeldung.com/apache-commons-csv

public class CsvUtil {
	public static void read() {
		Reader in = null;
		try {
			in = new FileReader("BatchSubmissionDetail_1002.csv");

			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(CyberSource.class).parse(in);
			Collection<CSVRecord> recordCols = StreamSupport.stream(records.spliterator(), false)
					.collect(Collectors.toList());
			Integer size = recordCols.size();
//			Iterator<CSVRecord> i = records.iterator();
//			i.remove();
//			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
//			int count = 0;
//			for (CSVRecord record : records) {
			if (size > 1) {
				recordCols.stream().skip(1).forEach(record -> {
					String author = record.get(CyberSource.link_to_request);
					String title = record.get(CyberSource.reason_code);
					String z = record.get(CyberSource.cybs_mid);
					String a = record.get(CyberSource.Submission_File_ID);
					System.out.println(author + " " + title + " " + z + " " + a);
					if (null == title || title.isEmpty()) {
						System.out.println(Boolean.FALSE);
					} else {
						System.out.println("process");
					}
					String ref = record.get(CyberSource.merchant_ref_number);
					System.out.println(ref);
//				if (count++ > 0) {
					Long id = null;
					Integer status = null;
					String refNo = record.get(CyberSource.merchant_ref_number);
					if (null != refNo && !refNo.isEmpty()) {
						id = Long.parseLong(record.get(CyberSource.merchant_ref_number));
					}
					String reason = record.get(CyberSource.reason_code);
//					System.out.println("why false? " + record.get(CyberSource.reason_code));
					if (!reason.isEmpty()) {
						status = Integer.parseInt(record.get(CyberSource.reason_code));
					}
					System.out.println(id + " " + status);
//				}
				});
			} else {
				System.out.println("Only left header or empty : " + size);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("still working well cause i catch you");
			e.printStackTrace();
		}
	}

	public static void write() {
		List<Demo> list = Arrays.asList(new Demo(1, "1", true), new Demo(2, "2", false));

		try (FileWriter out = new FileWriter("input_detail.csv");
				CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader("id", "name", "active"));) {
			list.forEach(d -> {
				try {
					printer.printRecord(d.getId(), d.getName(), d.getActive());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		} catch (Exception e) {

		}
	}

	public static byte[] exportCSV() {

		List<Demo> list = Arrays.asList(new Demo(1, "1", true), new Demo(2, "2", false));
		try (ByteArrayOutputStream output = new ByteArrayOutputStream();
				CSVPrinter printer = new CSVPrinter(new OutputStreamWriter(output), CSVFormat.DEFAULT)) {
			printer.printRecord("Year", "Month", "Facility code", "Ward name", "Ward Code", "Is active", "Is icu",
					"Discipline", "Speciality", "Sub speciality", "Operational beds", "Official beds", "Ward Category",
					"Ward class");
			list.forEach(d -> {
				try {
					printer.printRecord(d.getId(), d.getName(), d.getActive());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			printer.flush();
			return output.toByteArray();
		} catch (Exception e) {
			return null;
		}
	}
}
