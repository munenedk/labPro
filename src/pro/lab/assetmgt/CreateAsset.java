package pro.lab.assetmgt;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateAsset extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CreateAsset() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 30, 122, 28);
		add(textField);
		textField.setColumns(10);

	}

}
