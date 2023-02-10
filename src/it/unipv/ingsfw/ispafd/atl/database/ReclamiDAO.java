package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModelSingleton;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.reclami.Reclamo;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Impiegato;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class ReclamiDAO{

	private String schema;
	private Connection conn;


	public ReclamiDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<Reclamo> selectReclami (ATLModelSingleton m)
	{
		ArrayList<Reclamo> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from reclamo";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Impiegato i = ((Impiegato)m.getUtenteByUsername(rs1.getString(6)));
				Utente u = m.getUtenteByUsername(rs1.getString(5));
				
				Reclamo f=new Reclamo(rs1.getString(1),rs1.getString(2),u,rs1.getString(4),rs1.getString(3),i);

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	public boolean insertReclamo(Reclamo f) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="INSERT INTO reclamo (titolo,testoreclamo,id,utente) VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getTitolo());
			st1.setString(2,f.getTesto());
			st1.setString(3, f.getId());
			st1.setString(4,f.getUtente().getUsername());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	
	public boolean updateRisposta(String id, String risposta, String username) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="UPDATE reclamo SET testorisposta=?,impiegato=? WHERE id=?";
			st1 = conn.prepareStatement(query);
			st1.setString(1, risposta);
			st1.setString(2, username);
			st1.setString(3, id);
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	
}

