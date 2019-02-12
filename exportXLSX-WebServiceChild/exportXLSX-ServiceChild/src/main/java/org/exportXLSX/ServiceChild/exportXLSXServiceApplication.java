package org.exportXLSX.ServiceChild;


import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class exportXLSXServiceApplication {
public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, IOException {
		
		SpringApplication.run(exportXLSXServiceApplication.class, args);
		ArrayList<Data> data = new ArrayList<Data>();
		data.add(new Data("hh","hh","juu","jj"));
		
		Field[] fields = data.get(0).getClass().getDeclaredFields();
			for (Field field : fields) {

			//System.out.println(field.getName().toString());
		}
			
			
	}


}
