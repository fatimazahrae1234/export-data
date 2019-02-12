package org.exportXLSX.ServiceChild;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UtilExport {
	
	
	public static Map<String,Map<String,String>> map = new HashMap();
	
	static {
		
		LinkedHashMap<String, String> mapPersonne = new LinkedHashMap<String, String>();
		
		mapPersonne.put("nom", "nom de la personne");
		mapPersonne.put("prenom", "prenom de la personne");
		mapPersonne.put("email", "email de la personne");
		mapPersonne.put("adresse", "adresse de la personne");
		
		LinkedHashMap<String, String> mapDepartement = new LinkedHashMap<String, String>();
		
		mapDepartement.put("numDep", "numéro du département");
		mapDepartement.put("nomDep", "nom du département");
		
		map.put("class org.exportXLSX.ServiceChild.Personne", mapPersonne);
		map.put("class org.exportXLSX.ServiceChild.Departement",mapDepartement);
	}
	
	
	public static void main(String[] args) {
		System.out.println(map);
	}

}
