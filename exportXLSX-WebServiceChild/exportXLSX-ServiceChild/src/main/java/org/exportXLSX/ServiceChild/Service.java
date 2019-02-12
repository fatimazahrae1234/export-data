package org.exportXLSX.ServiceChild;


import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.springframework.stereotype.Component;


@Component
public class Service {
	
	
	public FileData exporter(ArrayList<Data> data) throws IOException {
		
		String[] colonnes = {"nom", "prenom", "email", "adresse"};
	   
				
		 Workbook workbook = new SXSSFWorkbook();
			Sheet sheet = workbook.createSheet("data");
			Font headerFont = workbook.createFont();
			CellStyle style = workbook.createCellStyle();
			style.setFont(headerFont);
			
			Row headerRow = sheet.createRow(0);
			
			for (int i = 0; i < colonnes.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(colonnes[i]);
				cell.setCellStyle(style);
				}
			
			int rowNum = 1;
			
			for( Data d: data) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(d.getNom());
				row.createCell(1).setCellValue(d.getPrenom());
				row.createCell(2).setCellValue(d.getEmail());
				row.createCell(3).setCellValue(d.getAdresse());
			}
			
			ByteArrayOutputStream os = new ByteArrayOutputStream();
		    workbook.write(os);
		    byte[] bytes = os.toByteArray();
		    return new FileData("data.xlsx",Base64.getEncoder().encodeToString(bytes));
		
		}
	
	
public FileData multiExport(ArrayList<?> ...data) throws IOException, IllegalArgumentException, IllegalAccessException {
			
				Workbook workbook = new SXSSFWorkbook();
				for (int i = 0; i < data.length; i++) {
					Sheet sheet = workbook.createSheet("sheet "+i);
					Font headerFont = workbook.createFont();
					CellStyle style = workbook.createCellStyle();
					style.setFont(headerFont);
					
					
					Row headerRow = sheet.createRow(0);
				
					Field[] fields = data[i].get(0).getClass().getDeclaredFields();
					
					for (int j = 0; j < fields.length; j++) {
							//System.out.println(fields[j].getName().toString());
						sheet.setColumnWidth(j, 10000);

						for (Entry<String, Map<String, String>> entry : UtilExport.map.entrySet())
						{
							//System.out.println(data[i].get(0).getClass().toString());
						   // System.out.println(entry.getKey() + "/" + entry.getValue());
							if(data[i].get(0).getClass().toString().equals(entry.getKey())) {
								for (Entry<String, String> entry2 : entry.getValue().entrySet()) {
									if(fields[j].getName().toString().equals(entry2.getKey())) {
										Cell cell = headerRow.createCell(j);
										cell.setCellValue(entry2.getValue());
										cell.setCellStyle(style);
									}
									
								}
								 
							}
						}
						
					}
					 
									
					 int rowNum = 1;
						
					 for (int j = 0; j < data[i].size(); j++) {
						Row row = sheet.createRow(rowNum++);
						for (int k = 0; k < fields.length; k++) {
								fields[k].setAccessible(true);
								row.createCell(k).setCellValue(fields[k].get(data[i].get(j)).toString());
							}
							
						}
				}
		
					
			ByteArrayOutputStream os = new ByteArrayOutputStream();
		    workbook.write(os);
		    byte[] bytes = os.toByteArray();
		    return new FileData("datamultiType.xlsx",Base64.getEncoder().encodeToString(bytes));
		
		}
	
		
		public ArrayList<?>[] afficher(ArrayList<?>... arrayLists ) {
		
			return arrayLists;
		}
	

}
