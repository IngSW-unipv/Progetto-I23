package it.unipv.ingsfw.ispafd.atl.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import it.unipv.ingsfw.ispafd.atl.model.abbonamenti.TipoAbbonamento;

public class TipoAbbonamentiDAO{

	private String schema;
	private Connection conn;


	public TipoAbbonamentiDAO() {
		super();
		this.schema = "atldb";
//		conn=DBConnection.startConnection(conn,schema);
	}

	public ArrayList<TipoAbbonamento> selectTipoAbbonamenti ()
	{
		ArrayList<TipoAbbonamento> result = new ArrayList<>();

		conn=DBConnection.startConnection(conn,schema);
		Statement st1;
		ResultSet rs1;

		try
		{
			st1 = conn.createStatement();
			String query="SELECT * from tipoabbonamento";
			rs1=st1.executeQuery(query);

			while(rs1.next())
			{
				boolean isabb=false;
				if(rs1.getInt(5)==1) {
					isabb=true;
				}
				
				TipoAbbonamento f=new TipoAbbonamento(rs1.getString(1), isabb ,rs1.getLong(2),rs1.getString(3),rs1.getDouble(4));

				result.add(f);
			}
		}catch (Exception e){e.printStackTrace();}

		DBConnection.closeConnection(conn);
		return result;
	}
	
}

