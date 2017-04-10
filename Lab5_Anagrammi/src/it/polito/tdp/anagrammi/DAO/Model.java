package it.polito.tdp.anagrammi.DAO;

import java.util.*;

import it.polito.tdp.anagrammi.model.AnnagrammaDAO;

public class Model {

	private AnnagrammaDAO aDAO = new AnnagrammaDAO () ;
	private List<String> anagrammi = new ArrayList<String>() ;
	
	public Model() {
		super();
	}
	
	private String parolaIniziale = null; 
	private List <Lettera> parolaLettera = new ArrayList <Lettera>();
	
	private List<Character> caratteri(List<Lettera> parziale){
		List <Character> c = new ArrayList<Character> ();
		for(Lettera l : parziale){
			c.add(l.getC());
		}
		return c;
	}
	
	private void calcola(List<Lettera> parziale, int livello){
		
		if(livello!=parolaIniziale.length()){
	
			for(Lettera l : this.parolaLettera){
				
				if(!parziale.contains(l)){
					parziale.add(l);
					this.calcola(parziale, livello+1);
					parziale.remove(l) ;
				}
			}
		}
		else{
			String temp = "";
			for(char c : this.caratteri(parziale)){
				temp+=c;
			}
			this.aggiungiAnagramma(temp);
		}
	}
	
	public String getParolaIniziale() {
		return parolaIniziale;
	}

	public void setParolaIniziale(String parolaIniziale) {
		this.parolaIniziale = parolaIniziale;
	}

	public void setParola(String parola){
		char[] array = parola.toCharArray();
		for(int i=0 ; i<array.length ; i++){
			parolaLettera.add(new Lettera(array[i], i));
		}
		this.parolaIniziale = parola ;
	}
	
	private void aggiungiAnagramma(String s){
		if(!anagrammi.contains(s)){
			anagrammi.add(s);
		}
	}
	
	public List<String> risolvi(){
		List<Lettera> parziale = new ArrayList<Lettera>() ;
		this.calcola(parziale, 0);
		
		return anagrammi;
	}
	
	public boolean isCorrect(String parola){
		return this.aDAO.isCorrect(parola);
	}
	
}
