package lojinha.Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import lojinha.BD.ConexaoMySQL;

public class CadastroProduto {
		
	public CadastroProduto() {
		// TODO Auto-generated constructor stub
	}
	
	
	Connection conexao;  //import java.sql.Connection;	
	//Método para fazer INSERT	
		
		

		public boolean cadastrarProduto(String nome_produto, String categoria_produto, float preco_produto){
			
			//Criação do comando a ser executado no banco de dados
			//INSERT INTO tb_produto (nome_produto, categoria_produto, preco_produto) 
			String comandoSQL = "INSERT INTO tb_produto VALUES(null,?,?,?,null);";
			
			//Abertura da conexão (usando a classe montada anteriormente)
			conexao = new ConexaoMySQL().iniciarConexao(); //import do pacote
			
			try{
				//Preparar a conexão com o comando que será executado nela
				PreparedStatement prepared_statement = conexao.prepareStatement(comandoSQL);
				
				//Passagem de valores para cada ? do comando INSERT
				
				prepared_statement.setString(1, nome_produto); //O número 1 indica a primeira coluna?
				prepared_statement.setString(2, categoria_produto);
				prepared_statement.setFloat(3, preco_produto);
				
				
				//Execução do comando no Banco de Dados e teste do que foi retornado
				if(prepared_statement.executeUpdate() != 0){
					//Se alterou pelo menos 1 linha, então o INSERT deu certo
					JOptionPane.showMessageDialog(null, "Dados inseridos");
					conexao.close(); //Fecha a conexão e libera o recurso
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
