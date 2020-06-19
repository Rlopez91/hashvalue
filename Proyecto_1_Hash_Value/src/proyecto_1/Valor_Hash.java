package proyecto_1;

import javax.swing.*;
import java.awt.event.*;


public class Valor_Hash implements ActionListener{
	
	private JFrame ventana; 
	private JLabel lbl_titulo, lbl_entradas, lbl_palabra, lbl_hash;
	private JTextField tf_entradas, tf_palabra, tf_hash;
	private JButton btn_calcular;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Valor_Hash();
	}
	
	Valor_Hash(){
		ventana = new JFrame("Valor Hash");
		ventana.setBounds(20, 20, 500, 500);
		ventana.setLayout(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_titulo = new JLabel("CALCULAR CLAVE HASH");
		lbl_titulo.setBounds(160, 20, 200, 30);
		ventana.add(lbl_titulo);
		
		lbl_entradas = new JLabel("Numero de entradas:");
		lbl_entradas.setBounds(20, 80, 200, 20);
		ventana.add(lbl_entradas);
		
		tf_entradas = new JTextField();
		tf_entradas.setBounds(160, 80, 200, 20);
		ventana.add(tf_entradas);
		
		lbl_palabra = new JLabel("Introduzca una palabra:");
		lbl_palabra.setBounds(20, 130, 200, 20);
		ventana.add(lbl_palabra);
		
		tf_palabra = new JTextField();
		tf_palabra.setBounds(160, 130, 200, 20);
		ventana.add(tf_palabra);
		
		btn_calcular = new JButton("CALCULAR");
		btn_calcular.setBounds(160, 180, 100, 30);
		btn_calcular.addActionListener(this);
		ventana.add(btn_calcular);
		
		lbl_hash = new JLabel("Valor Hash:");
		lbl_hash.setBounds(20, 240, 200, 20);
		ventana.add(lbl_hash);
		
		tf_hash = new JTextField();
		tf_hash.setBounds(110, 240, 150, 20);
		ventana.add(tf_hash);
		
		ventana.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn_calcular) {
			int codigo = 0, potencia = tf_palabra.getText().length()-1, hash=0;
			int entrada = Integer.parseInt(tf_entradas.getText());
			
			for(int i=0;i<tf_palabra.getText().length(); i++) {
				//System.out.println((Character.getNumericValue(tf_palabra.getText().charAt(i))-9)*Math.pow(28, potencia));
				//System.out.println(Math.pow(28, potencia));
				if(tf_palabra.getText().charAt(i)=='ñ'){
					codigo = codigo + (15*(int)Math.pow(28, potencia));
				}
				
				else if(Character.getNumericValue(tf_palabra.getText().charAt(i))-9>15) {
					codigo = codigo + (Character.getNumericValue(tf_palabra.getText().charAt(i))-8)*(int)Math.pow(28, potencia);
				}
				
				else {
					codigo = codigo + (Character.getNumericValue(tf_palabra.getText().charAt(i))-9)*(int)Math.pow(28, potencia);
				}
				potencia = potencia - 1;
			}
			
			hash = codigo%entrada;
			tf_hash.setText(String.valueOf(hash));
		}
	}

}
