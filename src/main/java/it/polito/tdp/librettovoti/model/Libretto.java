package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.List;

public class Libretto {

	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
	}
	
	/*
	public String votiUguali(int punteggio) {
		//calcola una stringa che contiene i voti
		//sarà poi il chiamante a stamparli
		// -> solo il NOME?
		// -> tutto il voto.toString()
	}
	
	*/
	
	/**
	 * Ricerca una serie di Voti di cui è specificato il punteggio
	 * @param punteggio
	 * @return Lista contenente i voti
	 */
	public List<Voto> listaVotiUguali(int punteggio){
		List<Voto> risultato = new ArrayList<>();
		for(Voto v : voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	/**
	 * Ricerca una serie di Voti di cui è specificato il punteggio
	 * @param punteggio
	 * @return Libretto contenente un insieme di voti
	 */
	public Libretto votiUguali(int punteggio) {
		Libretto risultato = new Libretto();
		for(Voto v : voti) {
			if(v.getVoto()==punteggio) {
				risultato.add(v);
			}
		}
		return risultato;
	}
	
	/**
	 * Ricerca un Voto del corso di cui è specificato il nome del corso
	 * Se il corso non esiste, restituisce null.
	 * @param nomeCorso
	 * @return
	 */
	public Voto ricercaCorso(String nomeCorso) {
		Voto risultato = null;
		for(Voto v : voti) {
			if(v.getNomeCorso().equals(nomeCorso)) {
				risultato = v;
				break;
			}
		}
		return risultato;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString()+"\n";
		}
		return s;
	}
}
