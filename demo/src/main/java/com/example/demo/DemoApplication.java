package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("demo")
public class DemoApplication {
	@RequestMapping("array")
	public String test(@RequestParam("demos[]")Demo[] demos) {
		return Arrays.asList(demos).toString();
	}

	@RequestMapping("list")
	public String test(List<String> ids) {
		return ids.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
