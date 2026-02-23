package com.br.rodrigo.streamrodao;

import com.br.rodrigo.streamrodao.domain2.Principal2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {
		Principal2 principal = new Principal2();
		principal.exibeMenu();
	}


}
