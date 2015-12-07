package pro.lab.coursemgt;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ReadCourse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tblCourseList;
	private JTextField txtSearchText;

	CourseController controller = new CourseController();

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public ReadCourse() {
		setLayout(null);

		JLabel lblCourseList = new JLabel("Course List");
		lblCourseList.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCourseList.setBounds(374, 15, 83, 16);
		add(lblCourseList);

		JScrollPane scrollPanetblCourseList = new JScrollPane();
		scrollPanetblCourseList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel records;
				records = (DefaultTableModel) tblCourseList.getModel();
				records.setRowCount(0);
				
				ArrayList<String[]> theCourses = controller.loadCourses();
				for (String[] item : theCourses) {
					records.addRow(item);
				}
			}
		});
		scrollPanetblCourseList.setBounds(39, 43, 785, 282);
		add(scrollPanetblCourseList);

		tblCourseList = new JTable();
		tblCourseList.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Course Code", "Course Name",
				"Exp. Capacity", "Program", "Prerequisite", "Resources", "Degree" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblCourseList.getColumnModel().getColumn(0).setPreferredWidth(86);
		tblCourseList.getColumnModel().getColumn(1).setPreferredWidth(94);
		tblCourseList.getColumnModel().getColumn(2).setPreferredWidth(83);
		tblCourseList.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblCourseList.getColumnModel().getColumn(4).setPreferredWidth(88);
		tblCourseList.getColumnModel().getColumn(5).setPreferredWidth(134);
		scrollPanetblCourseList.setViewportView(tblCourseList);

		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSearch.setBounds(374, 338, 55, 16);
		add(lblSearch);

		JLabel lblSearchFilter = new JLabel("Search Filter");
		lblSearchFilter.setBounds(39, 384, 83, 16);
		add(lblSearchFilter);

		JComboBox<String> comboSearchFilter = new JComboBox<String>();
		comboSearchFilter.setModel(new DefaultComboBoxModel<String>(new String[] { "Course Code", "Course Name",
				"Expected Capacity", "Program", "Prerequisite", "Resources", "Degree" }));
		comboSearchFilter.setBounds(155, 378, 169, 28);
		add(comboSearchFilter);

		JLabel lblSearchText = new JLabel("Search Text");
		lblSearchText.setBounds(374, 384, 83, 16);
		add(lblSearchText);

		txtSearchText = new JTextField();
		txtSearchText.setBounds(490, 378, 259, 28);
		add(txtSearchText);
		txtSearchText.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(289, 436, 90, 28);
		add(btnSearch);

		JLabel lblClickTableTo = new JLabel("Click table to reload or refresh data");
		lblClickTableTo.setFont(new Font("SansSerif", Font.ITALIC, 11));
		lblClickTableTo.setBounds(321, 28, 189, 16);
		add(lblClickTableTo);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(391, 436, 90, 28);
		add(btnUpdate);

	}
}
