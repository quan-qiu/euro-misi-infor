package com.euromisi.infordatainterface;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class InforDataInterfaceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InforDataInterfaceApplication.class, args);
	}

}
