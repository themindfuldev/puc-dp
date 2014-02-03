package br.edu.pucminas.eip.pedidos;
import java.sql.*;

public class ConexaoBD {
	private Connection conn;

	public ConexaoBD(){
		try{
			String file = "C:\\BancoSqlite.s3db";
			Class.forName("org.sqlite.JDBC");
			this.conn = DriverManager.getConnection("jdbc:sqlite:" + file);
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public Statement criarStatement() throws SQLException {
		return this.conn.createStatement();
	}

}