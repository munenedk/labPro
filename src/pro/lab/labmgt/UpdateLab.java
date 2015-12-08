package pro.lab.labmgt;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateLab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLabCode;
	private JTextField txtLabName;
	private JTextField txtLabCapacity;
	private final ButtonGroup ResourceListedbuttonGroup = new ButtonGroup();
	private JTextField txtSearchText;

	/**
	 * Create the panel.
	 */
	public UpdateLab() {
		setLayout(null);

		JLabel lblLabCode = new JLabel("Lab ID");
		lblLabCode.setBounds(6, 95, 101, 16);
		add(lblLabCode);

		txtLabCode = new JTextField();
		txtLabCode.setBounds(119, 89, 257, 28);
		add(txtLabCode);
		txtLabCode.setColumns(10);

		JLabel lblLabName = new JLabel("Lab Name");
		lblLabName.setBounds(6, 142, 112, 16);
		add(lblLabName);

		txtLabName = new JTextField();
		txtLabName.setBounds(119, 136, 257, 28);
		add(txtLabName);
		txtLabName.setColumns(10);

		JLabel lblLabCapacity = new JLabel("Lab Capacity");
		lblLabCapacity.setBounds(6, 196, 101, 16);
		add(lblLabCapacity);

		txtLabCapacity = new JTextField();
		txtLabCapacity.setBounds(119, 190, 257, 28);
		add(txtLabCapacity);
		txtLabCapacity.setColumns(10);

		JLabel lblLabDetails = new JLabel("Lab Details");
		lblLabDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLabDetails.setBounds(157, 6, 117, 16);
		add(lblLabDetails);

		JLabel lblSWAssetGroup = new JLabel("SW. Asset Group");
		lblSWAssetGroup.setBounds(6, 253, 101, 16);
		add(lblSWAssetGroup);

		JComboBox<String> comboSWAssetGroup = new JComboBox<String>();
		comboSWAssetGroup.setBounds(119, 247, 257, 28);
		add(comboSWAssetGroup);

		JLabel lblIsTheResource = new JLabel("Is the group listed?");
		lblIsTheResource.setBounds(6, 301, 112, 16);
		add(lblIsTheResource);

		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setSelected(true);
		ResourceListedbuttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(130, 300, 115, 18);
		add(rdbtnYes);

		JRadioButton rdbtnNo = new JRadioButton("No");
		ResourceListedbuttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(252, 300, 115, 18);
		add(rdbtnNo);

		JButton btnSaveLab = new JButton("Save Lab");
		btnSaveLab.setBounds(157, 341, 112, 28);
		add(btnSaveLab);
		
		txtSearchText = new JTextField();
		txtSearchText.setBounds(119, 49, 155, 28);
		add(txtSearchText);
		txtSearchText.setColumns(10);
		
		JLabel lblSearchText = new JLabel("Search Text");
		lblSearchText.setBounds(6, 55, 92, 16);
		add(lblSearchText);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(286, 49, 90, 28);
		add(btnSearch);
	}
}
