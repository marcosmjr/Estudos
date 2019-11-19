package lojinha.BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;


public class ComandosBD {
	
	Connection conexao;  //import java.sql.Connection;	
	//Método para fazer INSERT	
		
		public boolean cadastrarCliente(String nome_cliente, String cpf_cliente, int data_nasc){
			
			//Criação do comando a ser executado no banco de dados
			//INSERT INTO tb_produto (nome_cliente, cpf_cliente, data_nasc) 
			String comandoSQL = "INSERT INTO tb_cliente VALUES(null,?,?,?);";
			
			//Abertura da conexão (usando a classe montada anteriormente)
			conexao = new ConexaoMySQL().iniciarConexao(); //import do pacote
			
			try{
				//Preparar a conexão com o comando que será executado nela
				PreparedStatement prepared_statement = conexao.prepareStatement(comandoSQL);
				
				//Passagem de valores para cada ? do comando INSERT
				
				prepared_statement.setString(1, nome_cliente); //O número 1 indica a primeira coluna?
				prepared_statement.setString(2, cpf_cliente);
				prepared_statement.setDouble(3, data_nasc);
				
				
				//Execução do comando no Banco de Dados e teste do que foi retornado
				if(prepared_statement.executeUpdate() != 0){
					//Se alterou pelo menos 1 linha, então o INSERT deu certo
					JOptionPane.showMessageDialog(null, "Dados inseridos");
					conexao.close(); //Fecha a conexão e libera o recurso
					return true;
				}
			}catch(Exception exc){
				exc.printStackTrace();
				System.out.println("Falhou");
			}
			//Caso aconteceu algum erro, retorna falso
			return false;
		}
		
		

		/******Comando SELECT******/
		/*public void mostrarSelect(){
			String comandoSQL = "SELECT * FROM tb_produto ;";  // faz pesquisa de todos os registro desta tabela 
			
			Connection conexao = new ConexaoMySQL().iniciarConexao();
			
			try{
				PreparedStatement ps = conexao.prepareStatement(comandoSQL);
				
				//Para recuperar os valores que o comando SELECT vai retornar do
				//banco de dados, devemos armazenar eles em um objeto do tipo
				//ResultSet
				ResultSet resultado = ps.executeQuery();//import java.sql.ResultSet
				
				//Percorrer os valores que o SELECT buscou
				System.out.println("PRODUTOS");
				while(resultado.next()){ //Enquanto tiverem linhas na tabela
					System.out.println("Código: " + resultado.getInt(1)); // o 1 representa a 1ª coluna 
					System.out.println("Nome: " + resultado.getString(2));
					System.out.println("Categoria: " + resultado.getString(3));
					System.out.println("Preço: " + resultado.getFloat(4));
					
					System.out.println(); //Imprimi uma linha em branco
				}
				//Fecha a conexão
				conexao.close();
			}catch(Exception exc){
				exc.printStackTrace();
			}
		}
		
		/******Comando DELETE******/	
	/*	public boolean deletarItemProduto(){
			//Criação do comando a ser executado no banco de dados
			//DELETE FROM tb_produto WHERE id_produto=numero_de_id 
			String comandoSQL = "DELETE fROM tb_produto WHERE id_produto=3;"; // comando delete
			
			//Abertura da conexão (usando a classe montada anteriormente)
			conexao = new ConectaMySql().iniciarConexao(); //import do pacote
			
			try{
				//Preparar a conexão com o comando que será executado nela
				PreparedStatement ps = conexao.prepareStatement(comandoSQL);
				
				//Execução do comando no Banco de Dados e teste do que foi retornado
				if(ps.executeUpdate() != 0){
					conexao.close(); //fecha conexao e libera recurso
					
					JOptionPane.showMessageDialog(null, "Item Deletado");
					
					return true;
				}
			}catch(Exception exc){
				exc.printStackTrace();
				//System.out.println("Falhou");
			}
			//Caso aconteceu algum erro, retorna falso
			return false;
		}
		
		/******Comando UPDATE ******/	
	/*	public boolean alterarProduto(){
			
			String comandoSQL = "UPDATE tb_produto SET nome_produto='Lasanha', categoria_produto='Congelados' WHERE id_produto=5;"; 
			
			//Abertura da conexão (usando a classe montada anteriormente)
			conexao = new ConectaMySql().iniciarConexao(); //import do pacote
			
			try{
				//Preparar a conexão com o comando que será executado nela
				PreparedStatement ps = conexao.prepareStatement(comandoSQL);
				
				//Execução do comando no Banco de Dados e teste do que foi retornado
				if(ps.executeUpdate() != 0){
					conexao.close(); //fecha conexao e libera recurso
					
					JOptionPane.showMessageDialog(null, "Item Alterado");
					
					return true;
				}
			}catch(Exception exc){
				exc.printStackTrace();
				//System.out.println("Falhou");
			}
			//Caso aconteceu algum erro, retorna falso
			return false;
		}
			
		/****** Operador BETWEEN *****/
	/*	public void filtroBetween(){
			String comandoSQL = "SELECT nome_cliente FROM tb_cliente WHERE data_nasc BETWEEN 1990110 AND 20001220;";  // faz pesquisa de todos os registro desta tabela 
			
			Connection conexao = new ConectaMySql().iniciarConexao();
			
			try{
				PreparedStatement ps = conexao.prepareStatement(comandoSQL);
				
				//Para recuperar os valores que o comando SELECT vai retornar do
				//banco de dados, devemos armazenar eles em um objeto do tipo
				//ResultSet
				ResultSet resultado = ps.executeQuery();//import java.sql.ResultSet
				
				
				System.out.println("Clientes");
				//Percorrer os valores que o SELECT buscou
				while(resultado.next()){ //Enquanto tiverem linhas na tabela
					System.out.println("Nome: " + resultado.getString(1)); // o 1 representa a 1ª coluna 								
				}
				
				//Fecha a conexão
				conexao.close();
			}catch(Exception exc){
				exc.printStackTrace();
			}
		}
		/*****************************/
		
	
	
	
}
