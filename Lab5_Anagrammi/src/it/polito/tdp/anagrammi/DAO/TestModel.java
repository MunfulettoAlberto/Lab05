package it.polito.tdp.anagrammi.DAO;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();

		model.setParola("coccop");
		String s = model.getParolaIniziale();
		
		System.out.println("Gli anagrammi di '"+s+"' sono:\n");
		for(String temp : model.risolvi()){
			System.out.println(temp+"\n");
		}
	}

}
