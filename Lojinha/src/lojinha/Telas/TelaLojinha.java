package lojinha.Telas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class TelaLojinha extends JFrame{
		private Container painel;
		
		private JMenuBar barraMenu;
		
		private JMenu menuArquivo;
		private JMenu menuCadastro;
		private JMenu menuPesquisa;
		private JMenu menuSobre;
		
		private JMenuItem itemSalvar;
		private JMenuItem itemSair;
		private JMenuItem itemCliente;
		private JMenuItem itemProduto;
		private JMenuItem itemVenda;
		private JMenuItem itemPesquisaCliente;
		private JMenuItem itemPesquisaProduto;

/***********Construtor************/	
	public TelaLojinha(){		

		inicializaComponentes();
		inicializaEventosMenu();
	}
/********************************/
	
	public void inicializaComponentes(){
		
/****Inicializa Tela principal****/
		
		setSize(450,350);
		setLocation(700, 300);
		setTitle("Lojinha");
		setVisible(true);
		painel = getContentPane();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
/****Cria Objetos****/		
		barraMenu = new JMenuBar();
		menuArquivo = new JMenu("Arquivo");
		menuCadastro = new JMenu("Cadastro");
		menuPesquisa = new JMenu("Pesquisa");
		menuSobre = new JMenu("Sobre");		
		
		itemSalvar = new JMenuItem("Salvar");
		itemSair = new JMenuItem("Sair");
		itemCliente = new JMenuItem("Cliente");
		itemProduto = new JMenuItem("Produto");
		itemVenda = new JMenuItem("Venda");
		itemPesquisaCliente = new JMenuItem("Pesquisar Cliente");
		itemPesquisaProduto = new JMenuItem("Pesquisar Produto");

		
	
/*****Adiciona os objetos ao menu****/		
		menuArquivo.add(itemSalvar);
		menuArquivo.add(itemSair);
		menuCadastro.add(itemCliente);
		menuCadastro.add(itemProduto);
		menuCadastro.add(itemVenda);
		menuPesquisa.add(itemPesquisaCliente);
		menuPesquisa.add(itemPesquisaProduto);
		
		barraMenu.add(menuArquivo);
		barraMenu.add(menuCadastro);
		barraMenu.add(menuPesquisa);
		barraMenu.add(menuSobre);
		setJMenuBar(barraMenu);
		setVisible(true);
	}
	
	
	
	
	public void inicializaEventosMenu(){
/****Eventos do menu aquivo****/			
		
		/*itemSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		itemSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		});
		
/****Eventos do menu Cadastro****/
		itemCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(/*Inserir itens do contrutos */);
				painel.removeAll();
				painel.add(telaCadastroCliente);
				painel.validate();				
			}
		});
		
		itemProduto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(/*Inserir itens do contrutos */);
				painel.removeAll();
				painel.add(telaCadastroProduto);
				painel.validate();				
			}
		});
		
		itemVenda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaVenda telaVenda = new TelaVenda(/*Inserir itens do contrutos */);
				painel.removeAll();
				painel.add(telaVenda);
				painel.validate();
				
			}
		});
/****Colocar aqui itens de menu****/
		
itemPesquisaCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TelaPesquisaCliente telaPesquisaVenda = new TelaPesquisaCliente(/*Inserir itens do contrutos */);
				painel.removeAll();
			//	painel.add(telaPesquisaVenda);
				painel.validate();
				
			}
		});
		
itemPesquisaProduto.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		TelaPesquisaProduto telaPesquisaProduto = new TelaPesquisaProduto(/*Inserir itens do contrutos */);
		painel.removeAll();
		//painel.add(telaPesquisaProduto);
		painel.validate();
		
	}
});
		
		
/**********************************/		
		
	}
/****************************/
}


	
		

