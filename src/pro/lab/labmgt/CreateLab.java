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
	private JTextField txtMachineCode;
	private JTextField txtComments;
	private JTextField txtResourceID;
	private JTextField txtResources;

	/**
	 * Create the panel.
	 */
	public CreateLab() {
		setLayout(null);

		JLabel lblLabCode = new JLabel("Lab Code");
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

		JSeparator coursePrereqSeparator = new JSeparator();
		coursePrereqSeparator.setOrientation(SwingConstants.VERTICAL);
		coursePrereqSeparator.setBounds(418, 6, 11, 417);
		add(coursePrereqSeparator);

		JLabel lblMachineDetails = new JLabel("Machine Details");
		lblMachineDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblMachineDetails.setBounds(648, 6, 102, 16);
		add(lblMachineDetails);

		JLabel lblMachineCode = new JLabel("Machine Code");
		lblMachineCode.setBounds(459, 46, 132, 16);
		add(lblMachineCode);

		txtMachineCode = new JTextField();
		txtMachineCode.setBounds(603, 40, 237, 28);
		add(txtMachineCode);
		txtMachineCode.setColumns(10);

		JLabel lblResource = new JLabel("Resource");
		lblResource.setBounds(6, 212, 112, 16);
		add(lblResource);

		JComboBox<String> comboResource = new JComboBox<String>();
		comboResource.setBounds(130, 206, 237, 28);
		add(comboResource);

		JLabel lblIsTheResource = new JLabel("Is the Resc. listed?");
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

		JLabel lblComments = new JLabel("Comments");
		lblComments.setBounds(459, 86, 132, 16);
		add(lblComments);

		JButton btnSaveLab = new JButton("Save Lab");
		btnSaveLab.setBounds(157, 329, 112, 28);
		add(btnSaveLab);

		txtComments = new JTextField();
		txtComments.setBounds(603, 80, 237, 28);
		add(txtComments);
		txtComments.setColumns(10);

		JButton btnSaveMachine = new JButton("Save Machine");
		btnSaveMachine.setBounds(636, 133, 132, 28);
		add(btnSaveMachine);

		JSeparator prereqResourceSeparator = new JSeparator();
		prereqResourceSeparator.setBounds(459, 195, 395, 2);
		add(prereqResourceSeparator);

		JLabel lblResourceDetails = new JLabel("Resource Details");
		lblResourceDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblResourceDetails.setBounds(666, 219, 102, 16);
		add(lblResourceDetails);

		JLabel lblResourceIdentifier = new JLabel("Resource Identifier");
		lblResourceIdentifier.setBounds(459, 268, 132, 16);
		add(lblResourceIdentifier);

		txtResourceID = new JTextField();
		txtResourceID.setBounds(603, 262, 237, 28);
		add(txtResourceID);
		txtResourceID.setColumns(10);

		JLabel lblResources = new JLabel("Resources");
		lblResources.setBounds(459, 315, 132, 16);
		add(lblResources);

		txtResources = new JTextField();
		txtResources.setBounds(603, 309, 237, 28);
		add(txtResources);
		txtResources.setColumns(10);

		JButton btnSaveResource = new JButton("Save Resource");
		btnSaveResource.setBounds(648, 372, 120, 28);
		add(btnSaveResource);
	}

}
