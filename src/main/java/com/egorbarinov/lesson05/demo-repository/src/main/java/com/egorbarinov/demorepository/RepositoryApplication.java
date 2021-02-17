package com.egorbarinov.demorepository;

import com.egorbarinov.demorepository.repository.Bootstrap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RepositoryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Bootstrap.bootstrapPrepare();
	}
}
