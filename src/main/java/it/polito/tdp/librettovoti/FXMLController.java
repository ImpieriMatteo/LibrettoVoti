package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private TextField txtData;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	//Leggi e controlla i dati
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	}catch(NumberFormatException e) {
    		txtResult.setText("ERRORE: voto inserito non numerico");
    		return;
    	}
    	if(votoInt<18 || votoInt>30) {
    		txtResult.setText("ERRORE: voto inserito non valido");
    		return;
    	}
    	
    	String dataEsame = txtData.getText();
    	LocalDate data;
    	try {
    		data = LocalDate.parse(dataEsame);
    	}catch(Exception e) {
    		txtResult.setText("ERRORE: formato data inserita non corretta");
    		return;
    	}
    	
    	//Esegui l'azione
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	//Aggiorna i risultati
    	txtResult.setText(model.toString());
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtData != null : "fx:id=\"txtData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
