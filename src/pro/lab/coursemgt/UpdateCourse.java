package pro.lab.coursemgt;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UpdateCourse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCourseCode;
	private JTextField txtCourseName;
	private JTextField txtExpectedCapacity;
	private JLabel lblProgram;
	private final ButtonGroup prereqButtonGroup = new ButtonGroup();
	private final ButtonGroup PrereqListedbuttonGroup = new ButtonGroup();
	private final ButtonGroup ResourceListedbuttonGroup = new ButtonGroup();
	private JTextField txtPrereqID;
	private JTextField txtPrerequisites;
	private JTextField txtResourceID;
	private JTextField txtResources;

	/**
	 * Create the panel.
	 */
	public UpdateCourse() {
setLayout(null);
		
		JLabel lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setBounds(6, 46, 112, 16);
		add(lblCourseCode);
		
		txtCourseCode = new JTextField();
		txtCourseCode.setBounds(130, 40, 237, 28);
		add(txtCourseCode);
		txtCourseCode.setColumns(10);
		
		JLabel lblCourseName = new JLabel("Course Name");
		lblCourseName.setBounds(6, 86, 112, 16);
		add(lblCourseName);
		
		txtCourseName = new JTextField();
		txtCourseName.setBounds(130, 80, 237, 28);
		add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblExpectedCapacity = new JLabel("Expected Capacity");
		lblExpectedCapacity.setBounds(6, 133, 112, 16);
		add(lblExpectedCapacity);
		
		txtExpectedCapacity = new JTextField();
		txtExpectedCapacity.setBounds(130, 127, 237, 28);
		add(txtExpectedCapacity);
		txtExpectedCapacity.setColumns(10);
		
		lblProgram = new JLabel("Program");
		lblProgram.setBounds(6, 180, 112, 16);
		add(lblProgram);
		
		JComboBox<String> comboProgram = new JComboBox<String>();
		comboProgram.setModel(new DefaultComboBoxModel<String>(new String[] {"UNDG", "GRAD"}));
		comboProgram.setBounds(130, 174, 237, 28);
		add(comboProgram);
		
		JLabel lblDegree = new JLabel("Degree");
		lblDegree.setBounds(6, 219, 112, 16);
		add(lblDegree);
		
		JComboBox<String> comboDegree = new JComboBox<String>();
		comboDegree.setModel(new DefaultComboBoxModel<String>(new String[] {"IST", "APT", "MIST"}));
		comboDegree.setBounds(130, 214, 237, 28);
		add(comboDegree);
		
		JLabel lblCourseDetails = new JLabel("Course Details");
		lblCourseDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCourseDetails.setBounds(157, 6, 117, 16);
		add(lblCourseDetails);
		
		JSeparator coursePrereqSeparator = new JSeparator();
		coursePrereqSeparator.setOrientation(SwingConstants.VERTICAL);
		coursePrereqSeparator.setBounds(418, 6, 11, 417);
		add(coursePrereqSeparator);
		
		JLabel lblPrerequisiteDetails = new JLabel("Prerequisite Details");
		lblPrerequisiteDetails.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPrerequisiteDetails.setBounds(621, 6, 117, 16);
		add(lblPrerequisiteDetails);
		
		JLabel lblHasPrerequisite = new JLabel("Has Prerequisite?");
		lblHasPrerequisite.setBounds(6, 268, 112, 16);
		add(lblHasPrerequisite);
		
		JRadioButton rdbtnPrereqYes = new JRadioButton("Yes");
		prereqButtonGroup.add(rdbtnPrereqYes);
		rdbtnPrereqYes.setBounds(130, 267, 115, 18);
		add(rdbtnPrereqYes);
		
		JRadioButton rdbtnPrereqNo = new JRadioButton("No");
		rdbtnPrereqNo.setSelected(true);
		prereqButtonGroup.add(rdbtnPrereqNo);
		rdbtnPrereqNo.setBounds(252, 267, 115, 18);
		add(rdbtnPrereqNo);
		
		JLabel lblPrerequisite = new JLabel("Prerequisite");
		lblPrerequisite.setBounds(6, 302, 112, 16);
		add(lblPrerequisite);
		
		JComboBox<String> comboPrerequisites = new JComboBox<String>();
		comboPrerequisites.setBounds(130, 297, 237, 28);
		add(comboPrerequisites);
		
		JLabel lblIsThePrereq = new JLabel("Is the Prereq. listed?");
		lblIsThePrereq.setBounds(6, 337, 122, 16);
		add(lblIsThePrereq);
		
		JRadioButton rdbtnPrereqListedYes = new JRadioButton("Yes");
		rdbtnPrereqListedYes.setSelected(true);
		PrereqListedbuttonGroup.add(rdbtnPrereqListedYes);
		rdbtnPrereqListedYes.setBounds(130, 336, 115, 18);
		add(rdbtnPrereqListedYes);
		
		JRadioButton rdbtnPrereqListedNo = new JRadioButton("No");
		PrereqListedbuttonGroup.add(rdbtnPrereqListedNo);
		rdbtnPrereqListedNo.setBounds(252, 336, 115, 18);
		add(rdbtnPrereqListedNo);
		
		JLabel lblPrerequisiteIdentifier = new JLabel("Prerequisite Identifier");
		lblPrerequisiteIdentifier.setBounds(459, 46, 132, 16);
		add(lblPrerequisiteIdentifier);
		
		txtPrereqID = new JTextField();
		txtPrereqID.setBounds(603, 40, 237, 28);
		add(txtPrereqID);
		txtPrereqID.setColumns(10);
		
		JLabel lblResource = new JLabel("Resource");
		lblResource.setBounds(6, 372, 112, 16);
		add(lblResource);
		
		JComboBox<String> comboResource = new JComboBox<String>();
		comboResource.setBounds(130, 366, 237, 28);
		add(comboResource);
		
		JLabel lblIsTheResource = new JLabel("Is the Resc. listed?");
		lblIsTheResource.setBounds(6, 406, 112, 16);
		add(lblIsTheResource);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setSelected(true);
		ResourceListedbuttonGroup.add(rdbtnYes);
		rdbtnYes.setBounds(130, 405, 115, 18);
		add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		ResourceListedbuttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(252, 405, 115, 18);
		add(rdbtnNo);
		
		JLabel lblPrerequisites = new JLabel("Prerequisites");
		lblPrerequisites.setBounds(459, 86, 132, 16);
		add(lblPrerequisites);
		
		JButton btnSaveDetails = new JButton("Save Updates");
		btnSaveDetails.setBounds(369, 435, 112, 28);
		add(btnSaveDetails);
		
		txtPrerequisites = new JTextField();
		txtPrerequisites.setBounds(603, 80, 237, 28);
		add(txtPrerequisites);
		txtPrerequisites.setColumns(10);
		
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
	}

}
