package it.polito.tdp.librettovoti.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Libretto {

	private List<Voto> voti;
	private Map<String, Voto> votiMap; //identity map: nome esame --> oggetto Voto

	public Libretto() {
		this.voti = new ArrayList<>();
		this.votiMap = new HashMap<>();
	}
	
	public void add(Voto v) {
		this.voti.add(v);
		this.votiMap.put(v.getNomeCorso(), v);
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
//		Voto risultato = null;
//		for(Voto v : voti) {
//			if(v.getNomeCorso().equals(nomeCorso)) {
//				risultato = v;
//				break;
//			}
//		}
//		return risultato;
	
		return this.votiMap.get(nomeCorso);
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame e la stessa votazione.
	 * @param v
	 * @return
	 */
	public boolean esisteDuplicato(Voto v) {
//		boolean trovato = false;
//		for(Voto voto : this.voti) {
//			if(voto.getNomeCorso().equals(v.getNomeCorso()) && voto.getVoto()==v.getVoto()) {
//				trovato = true;
//				break;
//			}
//		}
//		return trovato;
		
		Voto trovato = this.votiMap.get(v.getNomeCorso());
		if(trovato==null)
			return false;
		if(trovato.getVoto()==v.getVoto())
			return true;
		else
			return false;
	}
	
	/**
	 * Verifica se nel libretto c'è già un voto con lo stesso esame ma con votazione diversa.
	 * @param v
	 * @return
	 */
	public boolean esisteConflitto(Voto v) {
//		boolean trovato = false;
//		for(Voto voto : this.voti) {
//			if(voto.getNomeCorso().equals(v.getNomeCorso()) && voto.getVoto()!=v.getVoto()) {
//				trovato = true;
//				break;
//			}
//		}
//		return trovato;
		
		Voto trovato = this.votiMap.get(v.getNomeCorso());
		if(trovato==null)
			return false;
		if(trovato.getVoto()!=v.getVoto())
			return true;
		else
			return false;
	}
	
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString()+"\n";
		}
		return s;
	}
}
