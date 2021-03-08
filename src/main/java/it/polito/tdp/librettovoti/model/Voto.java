package it.polito.tdp.librettovoti.model;

import java.time.LocalDate;

// POJO - Plain Old Java Object
// Java Bean
// Semplice contenitore di dati -- non ha "logica"

/**
 * Memorizza il risultato di un esame singolo
 * 
 * @author matte
 *
 */
public class Voto {

	private String nomeCorso;
	private int voto;  //30L come lo rappresento?
	private LocalDate dataEsame;
	
	/**
	 * Costruttore della classe Voto
	 * @param nomeCorso Nome del corso superato
	 * @param voto Voto ottenuto
	 * @param dataEsame Data di superamento
	 */
	public Voto(String nomeCorso, int voto, LocalDate dataEsame) {
		super();
		this.nomeCorso = nomeCorso;
		this.voto = voto;
		this.dataEsame = dataEsame;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}
	
	@Override
	public String toString() {
		return "Esame "+nomeCorso+" superato con "+voto+" il "+dataEsame;
	}
}
