package it.polito.tdp.spellchecker.controller;

import java.awt.List;
import java.net.URL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import it.polito.tdp.spellcheck.model.Dictionary;
import it.polito.tdp.spellcheck.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
 
	private Dictionary di = new Dictionary();
	
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
    }
    
    @FXML
    void doSeleziona(ActionEvent event) {
    	di.loadDictionary(cbxLingua.getValue()); 

    }

    @FXML
    void doSpellCheck(ActionEvent event) {
    	
//    	if(cbxLingua.getValue().equals("English"))
//        	di.loadDictionary("English");
//        else if(cbxLingua.getValue().equals("Italian"))
//        	di.loadDictionary("Italian"); 
    	
    	
   
    	String testo =txtTesto.getText().toLowerCase();
    	
    	
        String trad[]= testo.split(" ");
        
        for(int i=0;i<trad.length;i++)
        	System.out.println(trad[i]+"\n");
        
        LinkedList<String> controllare = new LinkedList<String>();
        
        
        
        for(int i =0; i<trad.length;i++){
        	controllare.add(trad[i]);
        }
        
        
        
       txtResult.setText(di.spellCheckText(controllare).toString());
        
        

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
