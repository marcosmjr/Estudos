package lojinha.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {

	 private final String DRIVER = "com.mysql.jdbc.Driver";
	    private final String DBNAME = "dsa_lojinha_marcos_moreira";// coloque o nome do Banco de dados que voce criou.
	    private final String URL = "jdbc:mysql://esn509vmysql/" + DBNAME;
	    private final String LOGIN = "aluno";
	    private final String SENHA = "Senai1234";
	//Objeto da classe Connection que ser� usado para configurar
		//o IP do banco, usu�rio e senha //import java.sql.Connection;
	    public Connection connection = null;
		
		//Criar um m�todo que ir� configurar o objeto conexao
		//O m�todo ir� retornar o pr�prio objeto conexao, ou seja, ao final de
		//tudo ser� retornado o estado da conex�o, isto �, conex�o aberta ou n�o
		public Connection iniciarConexao(){
			
			try {
				//Configura��o do Driver de banco de dados
				Class.forName(DRIVER);
				
				//Configura��o do caminho (IP), usu�rio, senha e banco de dados
				//O m�todo getConnection() tenta inicar a conex�o com os valores
				//passados como par�metro
				
	            connection = DriverManager.getConnection(URL, LOGIN, SENHA);
	                     
				
				System.out.println("Conectado com sucesso!");
				
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception exc) {
				// TODO Auto-generated catch block
				exc.printStackTrace();
			}
			return connection;

		}
		}


