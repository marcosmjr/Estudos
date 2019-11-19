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
	//Objeto da classe Connection que será usado para configurar
		//o IP do banco, usuário e senha //import java.sql.Connection;
	    public Connection connection = null;
		
		//Criar um método que irá configurar o objeto conexao
		//O método irá retornar o próprio objeto conexao, ou seja, ao final de
		//tudo será retornado o estado da conexão, isto é, conexão aberta ou não
		public Connection iniciarConexao(){
			
			try {
				//Configuração do Driver de banco de dados
				Class.forName(DRIVER);
				
				//Configuração do caminho (IP), usuário, senha e banco de dados
				//O método getConnection() tenta inicar a conexão com os valores
				//passados como parâmetro
				
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


