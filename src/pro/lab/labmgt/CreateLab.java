package pro.lab.labmgt;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateLab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLabCode;
	private JTextField txtLabName;
	private JTextField txtLabCapacity;
	private final ButtonGroup ResourceListedbuttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CreateLab() {
		setLayout(null);

		JLabel lblLabCode = new JLabel("Lab ID");
		lblLabCode.setBounds(6, 46, 112, 16);
		add(lblLabCode);

		txtLabCode = new JTextField();
		txtLabCode.setBounds(130, 40, 237, 28);
		add(txtLabCode);
		txtLabCode.setColumns(10);

		JLabel lblLabName = new JLabel("Lab Name");
		lblLabName.setBounds(6, 102, 112, 16);
		add(lblLabName);

		txtLabName = new JTextField();
		txtLabName.setBounds(130, 96, 237, 28);
		add(txtLabName);
		txtLabName.setColumns(10);

		JLabel lblLabCapacity = new JLabel("Lab Capacity");
		lblLabCapacity.setBounds(6, 158, 112, 16);
		add(lblLabCapacity);

		txtLabCapacity = new JTextField();
		txtLabCapacity.setBounds(130, 152, 237, 28);
		add(txtLabCapacity);
		txtLabCapacity.setColumns(10);

		JLabel lblLabDetails = new JLabel("Lab Details");
		lblLabDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLabDetails.setBounds(157, 6, 117, 16);
		add(lblLabDetails);

		JLabel lblSWAssetGroup = new JLabel("SW. Asset Group");
		lblSWAssetGroup.setBounds(6, 212, 112, 16);
		add(lblSWAssetGroup);

		JComboBox<String> comboSWAssetGroup = new JComboBox<String>();
		comboSWAssetGroup.setBounds(130, 206, 237, 28);
		add(comboSWAssetGroup);

		JLabel lblIsTheResource = new JLabel("Is the group listed?");
		lblIsTheResource.setBounds(6, 269, 112, 16);
		add(lblIsTheResource);

		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setSelected(true);
		ResourceListedbuttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(130, 268, 115, 18);
		add(rdbtnYes);

		JRadioButton rdbtnNo = new JRadioButton("No");
		ResourceListedbuttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(252, 268, 115, 18);
		add(rdbtnNo);

		JButton btnSaveLab = new JButton("Save Lab");
		btnSaveLab.setBounds(157, 329, 112, 28);
		add(btnSaveLab);
	}
}
