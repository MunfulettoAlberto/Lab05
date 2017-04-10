package it.polito.tdp.anagrammi.model;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class AnnagrammaDAO {

	public boolean isCorrect(String parola){
		final String sql =  "SELECT nome "+
							"FROM parola "+
							"WHERE nome = ?" ;

		boolean v = false;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()){
				v= true;
			}
			return v ;
		} catch(SQLException e){
			throw new RuntimeException("Errore Db");
		}
		
	}

	
}
