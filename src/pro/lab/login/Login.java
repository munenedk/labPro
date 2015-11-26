package pro.lab.login;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Please enter your username and password to log in");
		lblLogin.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblLogin.setBounds(294, 227, 343, 16);
		add(lblLogin);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setToolTipText("Username");
		txtUsername.setBounds(348, 275, 234, 40);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setToolTipText("Password");
		txtPassword.setBounds(348, 347, 234, 40);
		add(txtPassword);
		
		JButton btnLogin = new JButton("Log in");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnLogin.setBounds(348, 413, 234, 40);
		add(btnLogin);

	}
}
