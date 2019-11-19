package lojinha.Telas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import lojinha.Classes.CadastroProduto;
import lojinha.Classes.CadastroVenda;

public class TelaVenda extends JPanel{
	
	private JLabel jlQuantidadeProduto;
	private JLabel jlDataVendaProduto;
	private JLabel jlIdCliente;
	private JLabel jlIdProduto;
	
	private JTextField jtQuantidadeProduto;
	private JTextField jtIdCliente;
	private JTextField jtIdProduto;
	
	private JFormattedTextField jtDataVendaProduto;
	
	
	private MaskFormatter maskDataVendaProduto;
	
	private JButton jbCadastro;	
	
	
	
	/***********Construtor************/
	public TelaVenda(){
		inicializaComponentes();
		inicializarEventos();
	}
	/********************************/
	
	
	public void inicializaComponentes(){
		jlQuantidadeProduto = new JLabel("Quantidade");
		jlDataVendaProduto = new JLabel("Data de Venda");
		jlIdCliente = new JLabel("ID de Cliente");
		jlIdProduto = new JLabel("ID de Produto");
		
		
		try{
			
			maskDataVendaProduto = new MaskFormatter("##/##/####");
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		
		jtQuantidadeProduto = new JTextField();
		jtDataVendaProduto = new JFormattedTextField(maskDataVendaProduto);
		jtIdCliente = new JTextField();
		jtIdProduto = new JTextField();
		
		jbCadastro = new JButton("Cadastrar");
		
		add(jlQuantidadeProduto);
		add(jlDataVendaProduto);
		add(jlIdCliente);
		add(jlIdProduto);
		
		add(jtQuantidadeProduto);
		add(jtDataVendaProduto);
		add(jtIdCliente);
		add(jtIdProduto);
		
		add(jbCadastro);
		
		setLayout(null);
		jlQuantidadeProduto.setBounds(20, 50, 100, 20);
		jtQuantidadeProduto.setBounds(150,50,200,20);
		
		jlDataVendaProduto.setBounds(20, 90, 120, 20);
		jtDataVendaProduto.setBounds(150,90,100,20);
		
		jlIdCliente.setBounds(20, 130, 120, 20);
		jtIdCliente.setBounds(150,130,100,20);
		
		
		jlIdProduto.setBounds(20, 170, 120, 20);
		jtIdProduto.setBounds(150,170,100,20);
		
		jbCadastro.setBounds(150,210,100,20);
	}
	
	/********** Método icializarEventos **********/	

	public void inicializarEventos() {
		jbCadastro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(jtQuantidadeProduto.getText().equals("") ||jtDataVendaProduto.getText().equals("") ||
						jtIdCliente.getText().equals("") || jtIdProduto.getText().equals("")){
					
				JOptionPane.showMessageDialog(null, "Todos os campos devem ser preencidos");
				
				}else {
					String data = jtDataVendaProduto.getText();
					String array[] = new String[3];
					array = data.split("/");
					String novoFormatoData = array[2]+array[1] + array[0];
					
					CadastroVenda cadastro = new CadastroVenda();
					cadastro.cadastrarVenda(Integer.parseInt(jtQuantidadeProduto.getText()),Integer.parseInt(novoFormatoData), Integer.parseInt(jtIdCliente.getText()), Integer.parseInt(jtIdProduto.getText()));
					
							
									
					jtQuantidadeProduto.setText("");
					jtDataVendaProduto.setText("");
					jtIdCliente.setText("");
					jtIdProduto.setText("");
					
					}
			}
		});

	}// Fim do método inicializarEventos
	
}
