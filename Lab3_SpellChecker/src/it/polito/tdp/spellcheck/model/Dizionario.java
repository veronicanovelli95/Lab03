package it.polito.tdp.spellcheck.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dizionario {
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
	
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> corr = new ArrayList<RichWord>();
		boolean b=false;
		for(String s: inputTextList){
			b = controlla(s);
			RichWord r= new RichWord(s,b);
			corr.add(r);
			}
		return corr;
	}



	private boolean controlla(String s) {
		boolean trovato=false;
		for(String k: italiano){
			if(s.compareTo(k)==0)
				trovato=true;
		}
		return trovato;
	}
}