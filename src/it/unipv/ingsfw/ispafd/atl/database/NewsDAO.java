package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;

public class NewsDAO{

	private String schema;
	private Connection conn;


	public NewsDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<News> selectNews (ATLModel m)
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
	
}


