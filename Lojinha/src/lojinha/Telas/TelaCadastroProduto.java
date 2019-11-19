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

import lojinha.Classes.CadastroCliente;
import lojinha.Classes.CadastroProduto;

public class TelaCadastroProduto  extends JPanel{

	private JLabel jlNomeProduto;
	private JLabel jlCategoriaProduto;
	private JLabel jlPrecoProduto;
	
	private JTextField jtNomeProduto;
	private JTextField jtCategoriaProduto;
	private JTextField jtPrecoProduto;
	
	
	
	
	private JButton jbCadastro;	
	
	
	
	/***********Construtor************/
	public TelaCadastroProduto(){
		inicializaComponentes();
		inicializarEventos();
	}
	/********************************/

public void inicializaComponentes(){
	jlNomeProduto = new JLabel("Produto");
	jlCategoriaProduto = new JLabel("Categoria");
	jlPrecoProduto = new JLabel("Preco R$");
	
	
	
	jtNomeProduto = new JTextField();
	jtCategoriaProduto = new JTextField();
	jtPrecoProduto = new JTextField();
	
	jbCadastro = new JButton("Cadastrar");
	
	add(jlNomeProduto);
	add(jlCategoriaProduto);
	add(jlPrecoProduto);
	
	add(jtNomeProduto);
	add(jtCategoriaProduto);
	add(jtPrecoProduto);
	
	add(jbCadastro);
	
	setLayout(null);
	jlNomeProduto.setBounds(20, 50, 50, 20);
	jtNomeProduto.setBounds(150,50,200,20);
	
	jlCategoriaProduto.setBounds(20, 90, 120, 20);
	jtCategoriaProduto.setBounds(150,90,100,20);
	
	jlPrecoProduto.setBounds(20, 130, 120, 20);
	jtPrecoProduto.setBounds(150,130,100,20);
	
	jbCadastro.setBounds(150,170,100,20);
}

/********** Método icializarEventos **********/	

public void inicializarEventos() {
	jbCadastro.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(jtNomeProduto.getText().equals("") ||jtCategoriaProduto.getText().equals("") ||
					jtPrecoProduto.getText().equals("")){
				
			JOptionPane.showMessageDialog(null, "Todos os campos devem ser preencidos");
			
			}else {
				
				
				CadastroProduto cadastro = new CadastroProduto();
				cadastro.cadastrarProduto(jtNomeProduto.getText(),jtCategoriaProduto.getText(), Float.parseFloat(jtPrecoProduto.getText()));
				
						
								
				jtNomeProduto.setText("");
				jtCategoriaProduto.setText("");
				jtPrecoProduto.setText("");
				}
		}
	});

}// Fim do método inicializarEventos

}