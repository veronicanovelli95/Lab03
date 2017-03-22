package it.polito.tdp.spellchecker.controller;


import java.net.URL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellcheck.model.Dictionary;
import it.polito.tdp.spellcheck.model.Dictionary2;
import it.polito.tdp.spellcheck.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
	
	private Dictionary di = new Dictionary();
//	private Dictionary2 di = new Dictionary2();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cbxLingua;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Button bntSpellCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Label lblErrori;

    @FXML
    private Button btnClearText;

    @FXML
    private Label lblTempi;

    
    @FXML
    void doClearText(ActionEvent event) {
    	txtTesto.clear();
        txtResult.clear();
        lblTempi.setText("");
        lblErrori.setText("");
    }
    
    @FXML
    void doSeleziona(ActionEvent event) {
    	long t=System.nanoTime();
    	di.loadDictionary(cbxLingua.getValue()); 
    	long t2=System.nanoTime();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
   
    	String testo =txtTesto.getText().toLowerCase().replaceAll("[\\p{Punct}]", "");
    	testo.replaceAll("[ \\p{Punct}]", "");
    	
        String trad[]= testo.split(" ");
        
        for(int i=0;i<trad.length;i++)
        	System.out.println(trad[i]+"\n");
        
       List<String> controllare = new LinkedList<String>();
        
   
        for(int i =0; i<trad.length;i++){
        	controllare.add(trad[i]);
        }
        
        
        long t=System.nanoTime();
        List<RichWord> tr = new LinkedList<RichWord>(di.spellCheckText(controllare));
        for(RichWord r: tr)
        txtResult.appendText(r.getInput()+"\n");
        long t1=System.nanoTime();
       
       lblErrori.setText("Il testo contiene "+ tr.size()+" errore/i.");
   	  lblTempi.setText("Tempo necessario per la traduzione "+(t1-t)+ " nanosecondi.");
    }

    @FXML
    void initialize() {

        assert cbxLingua != null : "fx:id=\"cbxLingua\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert bntSpellCheck != null : "fx:id=\"bntSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblErrori != null : "fx:id=\"lblErrori\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTempi != null : "fx:id=\"lblTempi\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        cbxLingua.getItems().addAll("English", "Italian");
        cbxLingua.getSelectionModel().selectFirst();
    }
}
