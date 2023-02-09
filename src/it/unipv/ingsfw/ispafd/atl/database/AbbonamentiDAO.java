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
					f = new Abbonamento(u,t);
				}else {
					f = new Biglietto(u,t);
					Long d = rs1.getLong(5);
					if(d!=null) {
						((Biglietto) f).setDataTimbratura(d);
					}
				}
				
				f.setData_acquisto(rs1.getLong(2));
				
				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
}
