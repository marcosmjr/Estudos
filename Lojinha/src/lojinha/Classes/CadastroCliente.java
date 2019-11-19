package lojinha.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import lojinha.BD.ConexaoMySQL;

public class CadastroCliente {
		
	public CadastroCliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	Connection conexao;  //import java.sql.Connection;	
	//M�todo para fazer INSERT	
		
		

		public boolean cadastrarCliente(String nome_cliente, String cpf_cliente, String data_nasc){
			
			//Cria��o do comando a ser executado no banco de dados
			//INSERT INTO tb_cliente (nome_cliente, cpf_cliente, data_nasc) 
			String comandoSQL = "INSERT INTO tb_cliente VALUES(null,?,?,?);";
			
			//Abertura da conex�o (usando a classe montada anteriormente)
			conexao = new ConexaoMySQL().iniciarConexao(); //import do pacote
			
			try{
				//Preparar a conex�o com o comando que ser� executado nela
				PreparedStatement prepared_statement = conexao.prepareStatement(comandoSQL);
				
				//Passagem de valores para cada ? do comando INSERT
				
				prepared_statement.setString(1, nome_cliente); //O n�mero 1 indica a primeira coluna?
				prepared_statement.setString(2, cpf_cliente);
				prepared_statement.setString(3, data_nasc);
				
				
				//Execu��o do comando no Banco de Dados e teste do que foi retornado
				if(prepared_statement.executeUpdate() != 0){
					//Se alterou pelo menos 1 linha, ent�o o INSERT deu certo
					JOptionPane.showMessageDialog(null, "Dados inseridos");
					conexao.close(); //Fecha a conex�o e libera o recurso
					return true;
				}
			}catch(Exception exc){
				exc.printStackTrace();
				JOptionPane.showMessageDialog(null, "Falhou");
			}
			//Caso aconteceu algum erro, retorna falso
			return false;
		}
		
		
		
	
	

}
