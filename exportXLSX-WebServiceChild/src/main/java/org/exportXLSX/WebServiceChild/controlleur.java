package org.exportXLSX.WebServiceChild;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.exportXLSX.ServiceChild1.Data;
import org.exportXLSX.ServiceChild1.Departement;
import org.exportXLSX.ServiceChild1.FileData;
import org.exportXLSX.ServiceChild1.Personne;
import org.exportXLSX.ServiceChild1.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"}, allowedHeaders="*")
public class controlleur {
	
	Service service;
	
	@Autowired
	public void setService(Service service) {
		this.service = service;
	}

	
	@RequestMapping(value = "/data",method = RequestMethod.GET)
	FileData exporter() throws IOException, InvalidFormatException {
		ArrayList<Data> data =  new ArrayList<Data>();
		data.add(new Data("el masnaoui","fatima zahrae","elmasnaoui@gmail.com","rue XXX"));
		return service.exporter(data);
	   
	}
	
	
	@RequestMapping(value = "/exporter2",method = RequestMethod.GET)
	FileData multiExport() throws IOException, InvalidFormatException, IllegalArgumentException, IllegalAccessException {
		
		ArrayList<Personne> dataP =  new ArrayList<Personne>();
		dataP.add(new Personne("el masnaoui","fatima zahrae","elmasnaoui@gmail.com","rue XXX"));
		
		ArrayList<Departement> dataD =  new ArrayList<Departement>();
		dataD.add(new Departement(1,"Finance"));
		dataD.add(new Departement(2,"Base de donnees"));
		
	//	System.out.println(service.multiExport(dataP).getNomFichier());
		return service.multiExport(dataP,dataD);	   
	}
	
	@RequestMapping(value="/afficher")
	public ArrayList<?>[] afficher() {
		Data data = new Data("nom1","prenom1","email1","adr1");
		Data data1 = new Data("nom1","prenom1","email1","adr1");

		ArrayList<Data> array = new ArrayList<Data>();
		array.add(data);
		array.add(data1);
		
		ArrayList<Personne> arrayP = new ArrayList<Personne>();
		arrayP.add(new Personne("el masnaoui","fatima zahrae","email1@gmail.com","adr1"));
		return service.afficher(array,arrayP);
	}
	

}