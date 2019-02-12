package org.exportXLSX.ServiceChild;

public class FileData {
	
	private String nomFichier;
	private String data;


	public FileData(String nomFichier,String data) {
		this.nomFichier = nomFichier;
		this.data= data;
	}


	public String getNomFichier() {
		return nomFichier;
	}


	public void setNomFichier(String nomFichier) {
		this.nomFichier = nomFichier;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}
	
	
	

}
