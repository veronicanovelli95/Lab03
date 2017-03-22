package it.polito.tdp.spellcheck.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DizionarioInglese extends Dictionary{
	
	private List<String> inglese=new ArrayList<String>();
	
	public void loadDictionary(String language){
	
	try {
	      FileReader fr = new FileReader("rsc/English.txt");
	      BufferedReader br = new BufferedReader(fr);
	      String word;
	while ((word = br.readLine()) != null) {
		if(!inglese.contains(word))
	     inglese.add(word);
	} 
	br.close();
	} catch (IOException e){
	System.out.println("Errore nella lettura del file");
	}
	
	}
	
}
