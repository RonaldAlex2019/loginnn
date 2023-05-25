package paquet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loguio extends JFrame {

	private JPanel contentPane;
	private JTextField textUsario;
	private JPasswordField jpassClave;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loguio frame = new loguio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public loguio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 25, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(27, 90, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(27, 147, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		textUsario = new JTextField();
		textUsario.setBounds(73, 87, 107, 20);
		contentPane.add(textUsario);
		textUsario.setColumns(10);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(99, 144, 107, 20);
		contentPane.add(jpassClave);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] clave = jpassClave.getPassword();
				String claveFinal = new String(clave);
				
				if(textUsario.getText().equals("admin") && claveFinal.equals("123")) {
					
					dispose();
					JOptionPane.showMessageDialog(null, "Bienvenido al Sistema","INGRESASTE",
							JOptionPane.INFORMATION_MESSAGE);
					principal p = new principal();
					p.setVisible(true);
				}else {
					JOptionPane.showInputDialog(null, "Usario o Contraseña incorrecta","ERROR",
							JOptionPane.ERROR_MESSAGE);
					textUsario.setText("");
					jpassClave.setText("");
					textUsario.requestFocus();
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnIngresar.setBounds(295, 200, 107, 33);
		contentPane.add(btnIngresar);
	}
}
