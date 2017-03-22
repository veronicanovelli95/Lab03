package it.polito.tdp.spellcheck.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DizionarioItaliano extends Dictionary {
	private List<String> italiano=new ArrayList<String>();

	
	public void loadDictionary(String language){
	
	try {
	      FileReader fr = new FileReader("rsc/Italiano.txt");
	      BufferedReader br = new BufferedReader(fr);
	      String parola;
	while ((parola = br.readLine()) != null) {
		if(!italiano.contains(parola))
	     italiano.add(parola);
	} 
	br.close();
	} catch (IOException e){
	System.out.println("Errore nella lettura del file");
	}
	
	}
	
	
	
	
}