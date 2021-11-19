package com.celloud.demos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args); 
		logger.info("Application is Running ...");
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
