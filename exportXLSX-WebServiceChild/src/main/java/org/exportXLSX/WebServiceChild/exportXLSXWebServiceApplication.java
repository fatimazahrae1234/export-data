package org.exportXLSX.WebServiceChild;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages= {"org.exportXLSX"})
public class exportXLSXWebServiceApplication {

	public static void main(String[] args) throws InvalidFormatException, IllegalArgumentException, IllegalAccessException, IOException {
		
		SpringApplication.run(exportXLSXWebServiceApplication.class, args);
	
	}
	

}
