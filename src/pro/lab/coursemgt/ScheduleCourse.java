package pro.lab.coursemgt;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ScheduleCourse extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableGeneratedSchedule;

	CourseController controller = new CourseController();

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public ScheduleCourse() {
		setLayout(null);

		JButton btnGenerateSchedule = new JButton("Generate Schedule");
		btnGenerateSchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Working");
				DefaultTableModel records;
				String schedule_timeID, schedule_dayID;
				ArrayList<String[]> existingSchedule, allDaysTimes;

				records = (DefaultTableModel) tableGeneratedSchedule.getModel();
				records.setRowCount(0);

				// Query all courses without prerequisites & lab name and
				// capacity
				ArrayList<String[]> theCourses = controller.loadCoursesWithoutPrerequisits();
				ArrayList<String[]> theLabs = controller.loadLabNameAndCapacity();

				for (String[] course : theCourses) {
					for (String[] lab : theLabs) {

						// Compare the expected capacity of each course and the
						// lab capacities available (course capacity <= lab
						// capacity)
						if (Integer.parseInt(course[2]) <= Integer.parseInt(lab[1])) {

							System.out.println("Passed capacity check");

							// Compare the required course resources to the
							// available lab resources
							if (course[3].toString().equalsIgnoreCase(lab[2].toString())) {

								System.out.println("Passed resources check");
								existingSchedule = controller.loadSchedule(course[0].toString(), lab[3].toString());
								allDaysTimes = controller.loadAllPossibleDaysAndTimes();

								for (String[] DaysTimes : allDaysTimes) {

									System.out.println("Entered day-times check");

									if (existingSchedule.size() == 0) {
										System.out.println("Passed day-times check");
										records.addRow(new Object[] { course[0].toString(), course[1].toString(),
												lab[0].toString(), DaysTimes[0].toString(), DaysTimes[1].toString() });

										controller.SaveScheduledCourse(course[0].toString(), lab[3].toString(),
												DaysTimes[1].toString(), DaysTimes[0].toString());
									}

									for (String[] schedule : existingSchedule) {
										schedule_timeID = schedule[0]; // Times
										schedule_dayID = schedule[1]; // Days

										// If no day-time combination has been
										// scheduled for a particular course &
										// lab, schedule it
										if (!schedule_dayID.equalsIgnoreCase(DaysTimes[0])
												&& !schedule_timeID.equalsIgnoreCase(DaysTimes[1])) {
											System.out.println("Passed day-times check");
											records.addRow(new Object[] { course[0].toString(), course[1].toString(),
													lab[0].toString(), DaysTimes[0].toString(),
													DaysTimes[1].toString() });

											controller.SaveScheduledCourse(course[0].toString(), lab[3].toString(),
													DaysTimes[1].toString(), DaysTimes[0].toString());
										}
									}
								}
								// records.addRow(item);
							}
							JOptionPane.showMessageDialog(null,"Finished generating schedule");
						} else {
							// If expected capacity >= lab capacity then do
							// sectioning (IST1010A, IST1010B) until expected
							// capacity <= lab capacity or until there are no
							// more labs
						}

					} // inner foreach loop

				} // Outer foreach loop
			}
		});
		btnGenerateSchedule.setBounds(42, 25, 171, 28);
		add(btnGenerateSchedule);

		JButton btnSaveToExcel = new JButton("Save to Excel");
		btnSaveToExcel.setBounds(42, 81, 171, 28);
		add(btnSaveToExcel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(279, 26, 540, 410);
		add(scrollPane);

		tableGeneratedSchedule = new JTable();
		tableGeneratedSchedule.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Course Code", "Course Desc", "Lab", "Day", "Time" }) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, Object.class, String.class, Object.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableGeneratedSchedule.getColumnModel().getColumn(0).setPreferredWidth(93);
		scrollPane.setViewportView(tableGeneratedSchedule);
	}

}
