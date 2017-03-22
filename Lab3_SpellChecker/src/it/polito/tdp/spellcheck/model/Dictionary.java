package it.polito.tdp.spellcheck.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	private List<String> dizionario= new LinkedList<String>();
	

	public List<RichWord> spellCheckText(List<String> inputTextList){
		System.out.println("spell" + inputTextList.toString());
		List<RichWord> corr = new ArrayList<RichWord>();
		boolean b=false;
		
		
		for(String s: inputTextList){
			b = controlla(s);
			if(b==false){
			   RichWord r= new RichWord(s,b);
			   corr.add(r);}
			  }
		return corr;
	}



	private boolean controlla(String s) {
		boolean trovato=false;
		if(dizionario.contains(s))
				trovato=true;
	
		return trovato;
	}
	
	private boolean controllaDecotonica(String s){
		
		return false;
	}
	
	
	public void loadDictionary(String language){
			
			try {
			      FileReader fr = new FileReader("rsc/"+language+".txt");
			      BufferedReader br = new BufferedReader(fr);
			      String word;
			while ((word = br.readLine()) != null) {
				if(!dizionario.contains(word))
			     dizionario.add(word);
			} 
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
			
			}
	}



