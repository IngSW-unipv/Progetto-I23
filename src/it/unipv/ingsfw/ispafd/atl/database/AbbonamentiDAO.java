package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.ATLModel;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Abbonamento;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.Biglietto;
import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;
import it.unipv.ingsfw.ispafd.atl.model.news.News;
import it.unipv.ingsfw.ispafd.atl.model.utenti.Utente;

public class AbbonamentiDAO{

	private String schema;
	private Connection conn;


	public AbbonamentiDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<Abbonamento> selectAbbonamenti (ATLModel m)
	{
		ArrayList<Abbonamento> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from abbonamento ORDER BY data_acquisto";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				Abbonamento f=null;
				TipoAbbonamento t = m.getTipoAbbonamentoByNome(rs1.getString(4));
				Utente u = m.getUtenteByUsername(rs1.getString(1));
				
				if(t.getIsAbbonamento()==true) {
					f = new Abbonamento(u,t,rs1.getLong(2));
				}else {
					
					Long d = rs1.getLong(5);
					if(d!=null) {
						f = new Biglietto(u,t,rs1.getLong(2),d);
					}else {
						f = new Biglietto(u,t,rs1.getLong(2));
					}
				}
				
				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
	public boolean insertAbbonamento(Abbonamento f) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="INSERT INTO abbonamento (utente,data_acquisto,id,tipoabbonamento) VALUES(?,?,?,?)";
			st1 = conn.prepareStatement(query);
			st1.setString(1, f.getUtenteProprietario().getUsername());
			st1.setLong(2,f.getDataAcquisto());
			st1.setString(3, f.getId());
			st1.setString(4,f.getTipoAbbonamento().getNome());
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	
	public boolean updateTimbratura(String id, long datatimbratura) {

		conn=DBConnection.startConnection(conn,schema);
		PreparedStatement st1;
		
		boolean esito=true;

		try
		{
			
			String query="UPDATE abbonamento SET datatimbratura=? WHERE id=?";
			st1 = conn.prepareStatement(query);
			st1.setLong(1, datatimbratura);
			st1.setString(2, id);
			
			st1.executeUpdate();

		}catch (Exception e){
			e.printStackTrace();
			esito=false;
		}

		DBConnection.closeConnection(conn);
		return esito;

	}
	
}
