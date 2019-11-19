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

import lojinha.BD.ComandosBD;
import lojinha.Classes.CadastroCliente;

public class TelaCadastroCliente  extends JPanel{
	
	private JLabel jlNomeCliente;
	private JLabel jlCPFCliente;
	private JLabel jlDataNascimentoCliente;
	
	private JTextField jtNomeCliente;
	private JFormattedTextField jtCPFCliente;
	private JFormattedTextField jtDataNascimentoCliente;
	
	private MaskFormatter maskCPFCliente;
	private MaskFormatter maskDataNacimento;
	
	private JButton jbCadastro;
	
	/***********Construtor************/
	public TelaCadastroCliente(){
		inicializaComponentes();
		inicializarEventos();
		
	}
	/********************************/
	
	public void inicializaComponentes(){
		jlNomeCliente = new JLabel("Nome");
		jlCPFCliente = new JLabel("CPF");
		jlDataNascimentoCliente = new JLabel("Data de Nascimento");
		
		
		try{
			maskCPFCliente = new MaskFormatter("###.###.###-##");
			maskDataNacimento = new MaskFormatter("##/##/####");
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		
		jtNomeCliente = new JTextField();
		jtCPFCliente = new JFormattedTextField(maskCPFCliente);
		jtDataNascimentoCliente = new JFormattedTextField(maskDataNacimento);
		
		jbCadastro = new JButton("Cadastrar");
		
		add(jlNomeCliente);
		add(jlDataNascimentoCliente);
		add(jlCPFCliente);
		
		add(jtNomeCliente);
		add(jtDataNascimentoCliente);
		add(jtCPFCliente);
		
		add(jbCadastro);
		
		setLayout(null);
		jlNomeCliente.setBounds(20, 50, 50, 20);
		jtNomeCliente.setBounds(150,50,200,20);
		
		jlDataNascimentoCliente.setBounds(20, 90, 120, 20);
		jtDataNascimentoCliente.setBounds(150,90,100,20);
		
		jlCPFCliente.setBounds(20, 130, 120, 20);
		jtCPFCliente.setBounds(150,130,100,20);
		
		jbCadastro.setBounds(150,170,100,20);
		
		
		
	} // Fim do método inicializarComponentes
	
	/********** Método icializarEventos **********/	
		
		public void inicializarEventos() {
			jbCadastro.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(jtNomeCliente.getText().equals("") ||jtDataNascimentoCliente.getText().equals("") ||
							jtCPFCliente.getText().equals("")){
						
					JOptionPane.showMessageDialog(null, "Todos os campos devem ser preencidos");
					
					}else {
						String data = jtDataNascimentoCliente.getText();
						String array[] = new String[3];
						array = data.split("/");
						String novoFormatoData = array[2]+array[1] + array[0];
						
						CadastroCliente cadastro = new CadastroCliente();
						cadastro.cadastrarCliente(jtNomeCliente.getText(),jtCPFCliente.getText(), novoFormatoData);
						
								
						/*ComandosBD comandosDB = new ComandosBD();
						comandosDB.cadastrarCliente(jtNomeCliente.getText(),jtCPFCliente.getText(), Integer.parseInt(jtDataNascimentoCliente.getText()));*/
						
						jtNomeCliente.setText("");
						jtCPFCliente.setText("");
						jtDataNascimentoCliente.setText("");
						}
				}
			});
		
	}// Fim do método inicializarEventos
	
	
	
}
