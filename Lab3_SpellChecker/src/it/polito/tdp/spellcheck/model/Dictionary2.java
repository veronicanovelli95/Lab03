package it.polito.tdp.spellcheck.model;

import java.io.*;
import java.util.*;

public class Dictionary2 {
	
	private List<String> dizionario;
	
	public Dictionary2() {
		dizionario=new ArrayList<String>();
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		System.out.println("spell" + inputTextList.toString());
		List<RichWord> corr = new ArrayList<RichWord>();
		boolean b=false;
		
		dividiDizionario(dizionario);
		for(String s: inputTextList){
			b = controllaDecotonica(s);
			if(b==false){
			   RichWord r= new RichWord(s,b);
			   corr.add(r);}
			  }
		return corr;
	}


	private List<String> dizionario1=new ArrayList<String>();
	private List<String> dizionario2=new ArrayList<String>();
	
	private void dividiDizionario(List<String> dizionario3){
		int meta= dizionario.size()/2;
		for(int i=0;i<meta;i++)
			dizionario1.add(dizionario.get(i));
		for(int i=meta;i<=dizionario.size();i++)
			dizionario2.add(dizionario.get(i));
	}
	
	private boolean controllaDecotonica(String s){
		boolean trovato=false;
		if(s.compareTo(dizionario.get(dizionario.size()/2))<0){
		if(dizionario1.contains(s))
				trovato=true;}
		else
			if(dizionario2.contains(s))
				trovato=true;
	   return trovato;
		
	}
	
	
	public void loadDictionary(String language){
		dizionario.clear();	
		try {
			FileReader fr = new FileReader("rsc/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
//				if(!dizionario.contains(word))
			     dizionario.add(word);
			} 
			
			br.close();
			} 
		catch (IOException e){
			System.out.println("Errore nella lettura del file");
		}
			
	}
}



