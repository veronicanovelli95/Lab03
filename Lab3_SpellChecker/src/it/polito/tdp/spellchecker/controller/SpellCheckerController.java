package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellcheck.model.Dictionary;
import it.polito.tdp.spellcheck.model.Dizionario;
import it.polito.tdp.spellcheck.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SpellCheckerController {
    Dictionary in = new Dictionary();
    Dizionario it = new Dizionario();
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtTesto;

    @FXML
    private Button bntSpellCheck;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClearText;

    @FXML
    void doClearText(ActionEvent event) {
     txtTesto.clear();
     txtResult.clear();
    }

    @FXML
    void doSpellCheck(ActionEvent event) {
     String testo =txtTesto.getText();
     String trad[]= testo.split("\n");
     List<String> datradurre = new ArrayList<String>();
     
     for(int i =0; i<trad.length;i++){
    	 datradurre.add(trad[i]);}
     
     List<RichWord> de = new ArrayList<RichWord>();
     de = it.spellCheckText(datradurre);
     
     for(RichWord r: de){
    	 if(r.isGiusta()==true)
         txtResult.appendText(r.toString());
     }
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert bntSpellCheck != null : "fx:id=\"bntSpellCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}
