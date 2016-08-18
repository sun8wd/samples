package com.celloud.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class Test {

	public static void main(String[] args) throws Exception {
		// try {
		// List<String> lines = FileUtils.readLines(new
		// File("/Users/sun8wd/Documents/rocky/all.snp"));
		// List<String> newLines = new ArrayList<String>();
		// for (int i = 0; i <= 20; i++) {
		// newLines.add(lines.get(i));
		// }
		// FileUtils.writeLines(new
		// File("/Users/sun8wd/Documents/rocky/test.snp"), newLines);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		test5();
	}

	public static void test5() {
		Properties prop = new Properties();
		// group.id
		prop.setProperty("group.id", "aaa");
		prop.setProperty("enable.auto.commit", "true");
		prop.setProperty("auto.commit.interval.ms", "1000");
		prop.setProperty("session.timeout.ms", "30000");
		prop.setProperty("fetch.max.wait.ms", "200");
		prop.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		prop.setProperty("bootstrap.servers", "192.168.22.253:9092,192.168.22.253:9093");
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(prop);
		consumer.subscribe(Arrays.asList(new String[] { "user-message" }));
		consumer.poll(1000);
	}

	public static void test4() {
		BigDecimal m = new BigDecimal(3.14);
		BigDecimal n = BigDecimal.ZERO;
		System.out.println(m.add(n).toString());
	}

	public static void test3() {
		List<String> list = new ArrayList<>();
		list.add("split_R1_000.txt");
		list.add("split_.txt");
		list.add("split_R2_000.txt");
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String d1, String d2) {
				if (d1.contains("R1")) {
					return -11;
				}
				if (!d1.contains("R1") && !d1.contains("R2")) {
					return 1;
				}
				if (d1.contains("R2") && d2.contains("R1")) {
					return 1;
				}
				if (d1.contains("R2") && !d2.contains("R1")) {
					return -1;
				}
				return d1.compareTo(d2);
			}
		});
		for (String str : list) {
			System.out.println(str);
		}
	}

	public static void test2() {
		try {
			String str = URLDecoder.decode(
					"%E6%B5%A3%E8%B7%A8%E6%95%A4%E9%8A%86%E6%84%AD%E5%AB%91%E9%8D%9F%E5%97%9B%E6%91%B1%E7%90%9B%E5%B1%BB%EF%BC%9F%E7%BC%83%E6%88%A6%E6%91%B1%E9%8D%8F%E5%91%AD%EF%BC%9F%E9%8A%86%EF%BC%9F0.01%E9%8A%86%E6%88%9D%E5%8E%93%E9%8A%86%EF%BC%9F",
					"utf-8");
			System.out.println(str);
			str = new String(str.getBytes("gbk"), "utf-8");
			System.out.println(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static void test() throws IOException {
		List<String> lines = FileUtils.readLines(new File("/Users/sun8wd/Documents/python/des.txt"));
		FileUtils.writeLines(new File("/Users/sun8wd/Documents/python/des2.txt"), lines);
	}
}
