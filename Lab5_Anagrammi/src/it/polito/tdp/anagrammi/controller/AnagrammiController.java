package it.polito.tdp.anagrammi.controller;



import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.DAO.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	Model model = new Model();
	
	public void setModel(Model model){
		this.model = model;
	}
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnCalcola"
    private Button btnCalcola; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorrect"
    private TextArea txtCorrect; // Value injected by FXMLLoader

    @FXML // fx:id="txtUncorrect"
    private TextArea txtUncorrect; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	this.doReset(event);
    
    	List<String> anagrammi = new ArrayList<String>();
    	model.setParola(parola);
    	anagrammi.addAll(model.risolvi());
    	
    	if(parola.length()==0){
    		txtCorrect.setText("Nessun testo inserito");
    	}
    	for(String s : anagrammi){
    		if(model.isCorrect(s)){
    			txtCorrect.appendText(s+"\n");
    		}
    		else if(!model.isCorrect(s)){
        		txtUncorrect.appendText(s+"\n");
        	}
    	}
    	anagrammi.clear();
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorrect.clear();
    	txtUncorrect.clear();
    	txtParola.clear();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtCorrect != null : "fx:id=\"txtCorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtUncorrect != null : "fx:id=\"txtUncorrect\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
