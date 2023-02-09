package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Responsabile;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class UtentiDAO{

	private String schema;
	private Connection conn;


	public UtentiDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<Utente> selectUtenti ()
	{
		ArrayList<Utente> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from utente WHERE cf IS NULL";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Utente f=new Utente(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4));

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}
		
		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from utente WHERE cf IS NOT NULL AND isresponsabile!=1";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Utente f=new Impiegato(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5));

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}
		
		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from utente WHERE cf IS NOT NULL AND isresponsabile=1";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Utente f=new Responsabile(rs1.getString(1), rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5));

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
}
