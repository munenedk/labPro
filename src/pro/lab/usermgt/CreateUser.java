package pro.lab.usermgt;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateUser extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CreateUser() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 30, 122, 28);
		add(textField);
		textField.setColumns(10);

	}

}
