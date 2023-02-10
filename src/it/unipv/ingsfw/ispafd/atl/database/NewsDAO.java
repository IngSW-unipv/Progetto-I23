package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleTone;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class NewsDAO{

	private String schema;
	private Connection conn;


	public NewsDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<News> selectNews (ATLModelSingleTone m)
	{
		ArrayList<News> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from news";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				
				Impiegato i = (Impiegato) m.getUtenteByUsername(rs1.getString(4));
				
				News f=new News(rs1.getString(1),rs1.getString(2),i,rs1.getString(3));
				
				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	public boolean insertNews(News f) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="INSERT INTO news (titolo,testo,id,autore) VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getTitolo());
			st1.setString(2,f.getTesto());
			st1.setString(3, f.getId());
			st1.setString(4,f.getAutore().getUsername());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	
}


